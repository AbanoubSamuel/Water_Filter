package com.aqua.prod.common.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message)
    {
        super(message);
    }
}
