package com.oshovskii.otus.cloud.hystrix.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "pet-store", fallback = GreetingFeignFallback.class)
public interface GreetingClient {
    @GetMapping("/api/v1/greeting")
    String greeting();
}
