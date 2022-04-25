package com.akvelon.weather.service.converter;

import com.akvelon.weather.service.model.dto.WeatherDto;
import com.akvelon.weather.service.model.entity.Weather;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WeatherDtoConverter implements Converter<Weather, WeatherDto> {

    @Override
    public WeatherDto convert(Weather source) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setId(source.getId());
        weatherDto.setDate(source.getDate());
        weatherDto.setLat(source.getLat());
        weatherDto.setLon(source.getLon());
        weatherDto.setCity(source.getCity());
        weatherDto.setState(source.getState());
        weatherDto.setTemperatures(source.getTemperatures());
        return weatherDto;
    }
}
