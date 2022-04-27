package com.akvelon.weather.service.service.impl;

import com.akvelon.weather.service.converter.WeatherConverter;
import com.akvelon.weather.service.converter.WeatherDtoConverter;
import com.akvelon.weather.service.exception.WeatherServiceException;
import com.akvelon.weather.service.model.dto.WeatherDto;
import com.akvelon.weather.service.model.entity.Weather;
import com.akvelon.weather.service.repository.WeatherRepository;
import com.akvelon.weather.service.service.WeatherService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WeatherServiceImpl implements WeatherService {

    //repo
    WeatherRepository weatherRepository;
    //converter
    WeatherConverter weatherConverter;
    WeatherDtoConverter weatherDtoConverter;

    /**
     * {@inheritDoc}
     */
    @Override
    public WeatherDto create(WeatherDto weatherDto) {
        Weather weather = weatherRepository.save(weatherConverter.convert(weatherDto));
        return weatherDtoConverter.convert(weather);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<WeatherDto> getAll(Specification<Weather> spec, List<String> city, String sortDate) {
        Specification<Weather> citySpec = Specification.where(null);

        if (Objects.nonNull(city)) {
            for (String cityName : city) {
                Specification<Weather> cityPred = (root, query, criteriaBuilder) ->
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("city").as(String.class)),
                                "%" + cityName.toLowerCase() + "%");
                citySpec = citySpec.or(cityPred);
            }
        }
        Specification<Weather> finalSpec = Specification.where(citySpec.and(spec));
        List<Weather> weather;
        if (Objects.nonNull(sortDate)) {
            Sort.Direction dateDirection = Sort.Direction.ASC;
            if (sortDate.equals("-date")) {
                dateDirection = Sort.Direction.DESC;
            }
            Sort date = Sort.by(dateDirection, "date");
            weather = weatherRepository.findAll(finalSpec, date);

        } else {
            weather = weatherRepository.findAll(finalSpec);
        }


        return weather.stream().map(weatherDtoConverter::convert).collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WeatherDto getById(Long weatherId) {
        return weatherDtoConverter.convert(weatherRepository.findById(weatherId).orElseThrow(()
                -> new WeatherServiceException(HttpStatus.NOT_FOUND,
                String.format("Cannot found weather with id: %s", weatherId))));
    }
}
