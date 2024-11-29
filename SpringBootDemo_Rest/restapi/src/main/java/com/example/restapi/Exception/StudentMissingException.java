package com.example.restapi.Exception;

public class StudentMissingException extends RuntimeException {
    public StudentMissingException(String message) {
        super(message);
    }
}
