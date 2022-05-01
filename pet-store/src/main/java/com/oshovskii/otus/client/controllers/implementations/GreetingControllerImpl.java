package com.oshovskii.otus.client.controllers.implementations;

import com.oshovskii.otus.client.controllers.GreetingController;
import com.oshovskii.otus.client.services.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greeting")
@RequiredArgsConstructor
public class GreetingControllerImpl implements GreetingController {
    private final GreetingService greetingService;

    @Override
    @GetMapping
    public String greeting() {
        return greetingService.greeting();
    }
}
