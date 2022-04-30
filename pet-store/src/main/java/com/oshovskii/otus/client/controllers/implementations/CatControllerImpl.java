package com.oshovskii.otus.client.controllers.implementations;

import com.oshovskii.otus.client.controllers.CatController;
import com.oshovskii.otus.client.services.CatService;
import com.oshovskii.otus.cloud.dto.CatDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/cats")
@RequiredArgsConstructor
public class CatControllerImpl implements CatController {
    private final CatService catService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public CatDto findById(@PathVariable(value = "id") Long id) {
        return modelMapper.map(catService.findById(id), CatDto.class);
    }

    @GetMapping
    public List<CatDto> findAll() {
        return catService.findAll()
                .stream()
                .map(cat -> modelMapper.map(cat, CatDto.class))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        catService.deleteById(id);
    }
}
