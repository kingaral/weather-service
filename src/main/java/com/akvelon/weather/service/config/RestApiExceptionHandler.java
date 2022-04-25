package com.akvelon.weather.service.config;

import com.akvelon.weather.service.exception.WeatherServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler({WeatherServiceException.class})
    public ResponseEntity<Object> handleAccessDeniedException(
            WeatherServiceException ex) {
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }
}
