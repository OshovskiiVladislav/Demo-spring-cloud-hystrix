package com.oshovskii.otus.cloud.hystrix.feign;

import com.oshovskii.otus.cloud.dto.CatDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("pet-store")
public interface CatClient {
    @GetMapping("/api/v1/cats/{id}")
    CatDto findCatById(@PathVariable(value = "id") Long id);

    @GetMapping("/api/v1/cats")
    List<CatDto> findAll();

    @DeleteMapping("/api/v1/cats/{id}")
    void deleteById(@PathVariable(value = "id") Long id);
}
