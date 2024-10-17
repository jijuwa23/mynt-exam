package com.gcash.exam.gcash.exception;

public class MyntException extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;

    public MyntException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
