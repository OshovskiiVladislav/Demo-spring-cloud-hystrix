package com.oshovskii.otus.client.services;

import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GreetingService {
    private final EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    public String greeting(){
        return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
    }
}
