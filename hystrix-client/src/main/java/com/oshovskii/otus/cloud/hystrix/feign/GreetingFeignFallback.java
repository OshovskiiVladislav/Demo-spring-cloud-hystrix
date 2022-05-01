package com.oshovskii.otus.cloud.hystrix.feign;

import org.springframework.stereotype.Component;

@Component
public class GreetingFeignFallback implements GreetingClient {

    private static final String GREETING_FEIGN_FALLBACK = "Hello";

    @Override
    public String greeting() {
        return GREETING_FEIGN_FALLBACK;
    }
}
