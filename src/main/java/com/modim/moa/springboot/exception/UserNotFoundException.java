package com.modim.moa.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends RuntimeException {

    private final String email;

    public UserNotFoundException(String message, String email) {
        super(message);
        this.email = email;
    }

    public UserNotFoundException(String message, String email, Throwable throwable) {
        super(message, throwable);
        this.email = email;
    }

    public UserNotFoundException(String message, Throwable cause, String email) {
        super(message, cause);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
