package com.akvelon.weather.service.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class WeatherServiceException extends RuntimeException {

    private final HttpStatus status;
    private final String message;

    public WeatherServiceException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }
}
