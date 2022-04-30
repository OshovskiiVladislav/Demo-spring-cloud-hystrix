package com.oshovskii.otus.client.repositories;

import com.oshovskii.otus.client.models.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {
}
