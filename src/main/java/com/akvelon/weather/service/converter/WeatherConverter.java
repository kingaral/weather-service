package com.akvelon.weather.service.converter;

import com.akvelon.weather.service.model.dto.WeatherDto;
import com.akvelon.weather.service.model.entity.Weather;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class WeatherConverter implements Converter<WeatherDto, Weather> {

    @Override
    public Weather convert(WeatherDto source) {
        Weather weather = new Weather();
        weather.setDate(source.getDate());
        weather.setLat(source.getLat());
        weather.setLon(source.getLon());
        weather.setCity(source.getCity());
        weather.setState(source.getState());
        weather.setTemperatures(source.getTemperatures());
        return weather;
    }
}
