package com.oshovskii.otus.client.controllers;

import com.oshovskii.otus.client.controllers.implementations.GreetingControllerImpl;
import com.oshovskii.otus.client.services.GreetingService;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@DisplayName("GreetingController test")
@SpringJUnitWebConfig(classes = GreetingControllerImpl.class)
class GreetingControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService greetingService;

    @Test
    @DisplayName("greeting() " +
            "with void input" +
            "should return expected cat test")
    void greeting() throws Exception {
        // Config
        val expectedGreeting = "test";

        when(greetingService.greeting()).thenReturn(expectedGreeting);

        // Call and Verify
        mockMvc.perform(get("/api/v1/greeting"))
                .andExpect(content().string(expectedGreeting))
                .andExpect(status().isOk());
    }
}
