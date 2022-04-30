package com.oshovskii.otus.client.controllers;

import com.oshovskii.otus.cloud.dto.CatDto;

import java.util.List;

public interface CatController {
    CatDto findById(Long id);
    List<CatDto> findAll();
    void deleteById(Long id);
}
