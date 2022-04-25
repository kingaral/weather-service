package com.akvelon.weather.service.controller;

import com.akvelon.weather.service.model.dto.WeatherDto;
import com.akvelon.weather.service.model.entity.Weather;
import com.akvelon.weather.service.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/weather")
@Api("Functions to manipulate with weather")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WeatherController {

    WeatherService weatherService;

    @GetMapping
    @ApiOperation("Function to get all weather with filter")
    public ResponseEntity<List<WeatherDto>> getAllWeather(
            @And({
                    @Spec(path = "city", spec = LikeIgnoreCase.class),
                    @Spec(path = "date", spec = Equal.class)
            }) Specification<Weather> spec
    ) {
        return ResponseEntity.ok(weatherService.getAll(spec));
    }


    @GetMapping("/{weatherId}")
    @ApiOperation("Function to get weather by specific id")
    public ResponseEntity<WeatherDto> getWeather(@PathVariable Long weatherId) {
        return ResponseEntity.ok(weatherService.getById(weatherId));
    }

    @PostMapping
    @ApiOperation("Function to create weather")
    public ResponseEntity<WeatherDto> createWeather(@RequestBody WeatherDto weatherDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(weatherService.create(weatherDto));
    }
}

