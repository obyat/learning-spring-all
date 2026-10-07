package com.spring.ray.learning_spring_all.users.exception;

import java.time.LocalDateTime;


public record ErrorResponse(
        int status,
        String message,
        LocalDateTime timestamp
) {
}
