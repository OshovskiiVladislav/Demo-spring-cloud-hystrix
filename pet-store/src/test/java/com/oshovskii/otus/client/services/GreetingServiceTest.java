package com.oshovskii.otus.client.services;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@DisplayName("GreetingService test")
@ExtendWith(SpringExtension.class)
@Import(GreetingService.class)
@TestPropertySource(properties = { "spring.application.name = test" })
class GreetingServiceTest {

    @SpyBean
    private GreetingService greetingService;

    @MockBean
    private EurekaClient eurekaClientMock;

    @Test
    @DisplayName("greeting() " +
            "with void input " +
            "should return expected string test")
    void greeting_voidInput_shouldReturnExpectedString() {
        // Config
        val expectedString = "Hello from 'test'!";
        val expectedAppName = "test";

        when(eurekaClientMock.getApplication(anyString())).thenReturn(new Application(expectedAppName));

        // Call
        val actualString = greetingService.greeting();

        // Verify
        assertEquals(expectedString, actualString);
    }
}
