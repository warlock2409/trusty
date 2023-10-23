package com.example.trusty.Exceptions;

public class CarNumberDuplicateException extends RuntimeException {
    public CarNumberDuplicateException() {
        super();
    }

    public CarNumberDuplicateException(String message) {
        super(message);
    }

    public CarNumberDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarNumberDuplicateException(Throwable cause) {
        super(cause);
    }
}

