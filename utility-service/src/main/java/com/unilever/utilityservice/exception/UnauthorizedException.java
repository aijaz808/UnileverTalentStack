package com.unilever.utilityservice.exception;

public class UnauthorizedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnauthorizedException() {
        super("You are not authorized to perform this task.");
    }
}