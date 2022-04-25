package com.akvelon.weather.service.service;

import com.akvelon.weather.service.model.entity.Weather;
import com.akvelon.weather.service.model.dto.WeatherDto;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * Functions to work with weather
 */
public interface WeatherService {

    /**
     * Save weather
     * @param weatherDto {@link WeatherDto}
     * @return {@link WeatherDto}
     */
    WeatherDto create(WeatherDto weatherDto);

    /**
     * Get all weather by filter
     * @param spec specification with filter
     * @return list of {@link WeatherDto}
     */
    List<WeatherDto> getAll(Specification<Weather> spec);

    /**
     * Find weather by id
     * @param weatherId {@link WeatherDto#getId()}
     * @return {@link WeatherDto}
     */
    WeatherDto getById(Long weatherId);

}
