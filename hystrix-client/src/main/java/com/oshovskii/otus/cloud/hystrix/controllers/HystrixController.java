package com.oshovskii.otus.cloud.hystrix.controllers;

import com.oshovskii.otus.cloud.dto.CatDto;

import java.util.List;

public interface HystrixController {
    String greeting();
    List<CatDto> findAllCats();
    CatDto findCatById(Long id);
    String buyCatById(Long id);
}
