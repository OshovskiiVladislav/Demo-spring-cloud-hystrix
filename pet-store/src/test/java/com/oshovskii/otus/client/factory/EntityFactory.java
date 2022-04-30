package com.oshovskii.otus.client.factory;

import com.oshovskii.otus.client.models.Cat;

public class EntityFactory {
    public static Cat createCat(int index) {
        return new Cat(
                (long) index,
                "name_" + index,
                "breed" + index,
                index
        );
    }
}
