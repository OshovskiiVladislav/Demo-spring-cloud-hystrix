package com.oshovskii.otus.cloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatDto {
    private long id;
    private String name;
    private String breed;
    private int age;
}
