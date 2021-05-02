package com.modim.moa.springboot.exception;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ApiError {

    private final HttpStatus httpStatus;
    private final String message;
    private final String debugMessage;
    private final List<String> errors;

    public ApiError(HttpStatus httpStatus, Throwable ex) {
        this.httpStatus = httpStatus;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
        errors = null;
    }
}
