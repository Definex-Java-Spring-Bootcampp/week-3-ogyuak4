package com.patika.onlineshoppingservice.exceptions;

public class onlineshoppingException extends RuntimeException {

    private String message;

    public onlineshoppingException(String message) {
        super(message);
        this.message = message;
    }
}
