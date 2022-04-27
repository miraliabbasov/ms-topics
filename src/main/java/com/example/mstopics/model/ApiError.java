package com.example.mstopics.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiError {
    private Integer code;
    private String message;
    private LocalDateTime timestamp;

    public ApiError(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
