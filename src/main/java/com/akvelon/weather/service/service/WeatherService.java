package com.akvelon.weather.service.service;

import com.akvelon.weather.service.model.dto.WeatherDto;

import java.text.ParseException;
import java.util.List;

/**
 * Functions to work with weather
 */
public interface WeatherService {

    /**
     * Save weather
     *
     * @param weatherDto {@link WeatherDto}
     * @return {@link WeatherDto}
     */
    WeatherDto create(WeatherDto weatherDto);

    /**
     * Get all weather by filter
     *
     * @param date
     * @param city     City name
     * @param sortDate sort of date
     * @return list of {@link WeatherDto}
     */
    List<WeatherDto> getAll(String date, List<String> city, String sortDate) throws ParseException;

    /**
     * Find weather by id
     *
     * @param weatherId {@link WeatherDto#getId()}
     * @return {@link WeatherDto}
     */
    WeatherDto getById(Long weatherId);

}
