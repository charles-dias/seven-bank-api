package com.charles.sevenbankapi.common.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long accountNumber) {
        super("Account not found: " + accountNumber);
    }
}
