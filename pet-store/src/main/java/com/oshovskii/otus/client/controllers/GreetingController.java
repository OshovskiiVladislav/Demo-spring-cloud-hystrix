package com.oshovskii.otus.client.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public interface GreetingController {
    @GetMapping("/greeting")
    String greeting();
}

