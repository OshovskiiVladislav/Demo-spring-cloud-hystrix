package com.oshovskii.otus.cloud.hystrix.feign;

import com.oshovskii.otus.cloud.dto.CatDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CatFeignFallback implements CatClient {
    @Override
    public CatDto findCatById(Long id) {
        return new CatDto(id, "Tom", "British Cat", 3);
    }

    @Override
    public List<CatDto> findAll() {
        return List.of(new CatDto(1, "Tom", "British Cat", 3),
                       new CatDto(2, "Leo", "British Cat", 1)
        );
    }

    @Override
    public void deleteById(Long id) {
        log.info("Server pet-store does not respond [ deleteById() with id: " + id + " ]");
    }
}
