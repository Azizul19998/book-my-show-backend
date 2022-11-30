package com.example.bookMyShow.demo.exception;

public class DuplicateEntityException extends RuntimeException{
    private final String message;

    public DuplicateEntityException(String message) {
        super(message);
        this.message = message;
    }
}
