package com.oshovskii.otus.client.services;

import com.oshovskii.otus.client.repositories.CatRepository;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static com.oshovskii.otus.client.factory.EntityFactory.createCat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("CatService test")
@ExtendWith(SpringExtension.class)
@Import(CatService.class)
class CatServiceTest {

    @SpyBean
    private CatService catService;

    @MockBean
    private CatRepository catRepository;

    @Test
    @DisplayName("findById() " +
            "with valid cat id " +
            "should return expected cat test")
    void findById_validCatId_shouldReturnCat() {
        // Config
        val sourceCatId = 1L;
        val expectedCat = createCat(1);

        when(catRepository.findById(sourceCatId)).thenReturn(Optional.of(expectedCat));

        // Call
        val actualCat = catService.findById(sourceCatId);

        // Verify
        assertEquals(expectedCat, actualCat);
    }

    @Test
    @DisplayName("findAll()" +
            "with void input" +
            "should return expected list cat test")
    void findAll() {
        // Config
        val expectedCat1 = createCat(1);
        val expectedCat2 = createCat(2);

        val expectedCatList = List.of(expectedCat1, expectedCat2);

        when(catRepository.findAll()).thenReturn(expectedCatList);

        // Call
        val actualCatList = catService.findAll();

        // Verify
        assertEquals(expectedCatList, actualCatList);
    }

    @Test
    @DisplayName("deleteById()" +
            "with valid cat id" +
            "should delete expected cat test")
    void deleteById() {
        // Config
        val sourceCatId = 1L;

        doNothing().when(catRepository).deleteById(sourceCatId);

        // Call
        catService.deleteById(sourceCatId);

        // Verify
        verify(catRepository).deleteById(sourceCatId);
    }
}
