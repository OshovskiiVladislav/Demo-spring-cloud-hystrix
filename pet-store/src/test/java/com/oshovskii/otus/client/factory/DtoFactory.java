package com.oshovskii.otus.client.factory;

import com.oshovskii.otus.cloud.dto.CatDto;

public class DtoFactory {
    public static CatDto createCatDto(int index) {
        return new CatDto(
                (long) index,
                "name_" + index,
                "breed_" + index,
                index
        );
    }
}
