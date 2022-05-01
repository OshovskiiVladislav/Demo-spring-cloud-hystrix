package com.oshovskii.otus.client.exceptions.implementations;

import com.oshovskii.otus.client.exceptions.AbstractException;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends AbstractException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    @Override
    protected HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}