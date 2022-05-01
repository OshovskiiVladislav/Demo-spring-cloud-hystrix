package com.oshovskii.otus.cloud.hystrix.controllers.implementations;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.oshovskii.otus.cloud.dto.CatDto;
import com.oshovskii.otus.cloud.hystrix.controllers.HystrixController;
import com.oshovskii.otus.cloud.hystrix.feign.CatClient;
import com.oshovskii.otus.cloud.hystrix.feign.GreetingClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HystrixControllerImpl implements HystrixController {
    private final CatClient catClient;
    private final GreetingClient greetingClient;

    @GetMapping("/greeting")
    public String greeting() {
        return greetingClient.greeting();
    }

    @Override
    @GetMapping("/cats/{id}")
    public CatDto findCatById(@PathVariable(value = "id") Long id) {
        return catClient.findCatById(id);
    }

    @GetMapping("/cats")
    public List<CatDto> findAllCats() {
        return catClient.findAll();
    }

    @GetMapping("/cats/buy/{id}")
    public void buyCatById(@PathVariable(value = "id") Long id) {
        log.info("[buyCatById] with id: {}", id);
        catClient.deleteById(id);
    }
}
