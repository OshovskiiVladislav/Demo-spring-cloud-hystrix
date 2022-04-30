package com.oshovskii.otus.client.services;

import com.oshovskii.otus.client.exceptions.implementations.ResourceNotFoundException;
import com.oshovskii.otus.client.models.Cat;
import com.oshovskii.otus.client.repositories.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CatService {
    private final CatRepository catRepository;

    @Transactional(readOnly = true)
    public Cat findById(final Long id) {
        return catRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(format("Cat not found. Id: %s", id)));
    }

    @Transactional(readOnly = true)
    public List<Cat> findAll(){
        return catRepository.findAll();
    }

    @Transactional
    public void deleteById(final Long id) {
        catRepository.deleteById(id);
    }
}
