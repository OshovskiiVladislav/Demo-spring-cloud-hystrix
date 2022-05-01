package com.oshovskii.otus.client.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oshovskii.otus.client.controllers.implementations.CatControllerImpl;
import com.oshovskii.otus.client.services.CatService;
import com.oshovskii.otus.cloud.dto.CatDto;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.oshovskii.otus.client.factory.DtoFactory.createCatDto;
import static com.oshovskii.otus.client.factory.EntityFactory.createCat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@DisplayName("CatController test")
@SpringJUnitWebConfig(classes = CatControllerImpl.class)
class CatControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    public ObjectMapper objectMapper;

    @MockBean
    private ModelMapper modelMapperMock;

    @MockBean
    private CatService catServiceMock;

    @Test
    @DisplayName("findById() " +
            "with valid cat id" +
            "should return expected cat test")
    void findById_validCatId_shouldReturnCat() throws Exception {
        // Config
        val sourceCatId = 1L;
        val expectedCat = createCat(1);
        val expectedCatDto = createCatDto(1);

        when(catServiceMock.findById(sourceCatId)).thenReturn(expectedCat);
        when(modelMapperMock.map(expectedCat, CatDto.class)).thenReturn(expectedCatDto);

        val targetJson = objectMapper.writeValueAsString(expectedCatDto);

        // Call and Verify
        mockMvc.perform(get("/api/v1/cats/{id}", sourceCatId))
                .andExpect(content().string(targetJson))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("findAll() " +
            "with void input " +
            "should return expected list cats test")
    void findAll_voidInput_shouldReturnListCats() throws Exception {
        // Config
        val expectedCat1 = createCat(1);
        val expectedCat2 = createCat(1);

        val expectedCatDto1 = createCatDto(1);
        val expectedCatDto2 = createCatDto(1);

        val expectedListCat = List.of(expectedCat1, expectedCat2);
        val expectedListCatDto = List.of(expectedCatDto1, expectedCatDto2);

        when(catServiceMock.findAll()).thenReturn(expectedListCat);
        when(modelMapperMock.map(expectedCat1, CatDto.class)).thenReturn(expectedCatDto1);
        when(modelMapperMock.map(expectedCat2, CatDto.class)).thenReturn(expectedCatDto2);

        val targetJson = objectMapper.writeValueAsString(expectedListCatDto);

        // Call and Verify
        mockMvc.perform(get("/api/v1/cats"))
                .andExpect(content().string(targetJson))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("deleteById() " +
            "with valid cat id " +
            "should delete expected cat test")
    void deleteById_validCatId_shouldDeleteExpectedCat() throws Exception {
        // Config
        val sourceCatId = 1L;

        doNothing().when(catServiceMock).deleteById(sourceCatId);

        // Call and Verify
        mockMvc.perform(delete("/api/v1/cats/{id}", sourceCatId))
                .andExpect(status().isOk());
    }
}
