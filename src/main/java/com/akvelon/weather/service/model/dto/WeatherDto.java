package com.akvelon.weather.service.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@ApiModel("Dto of weather")
@FieldDefaults(level = PRIVATE)
public class WeatherDto {
    @ApiModelProperty("Id of the weather information")
    Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty("Day of the weather information")
    LocalDate date;
    @ApiModelProperty("Latitude of the city")
    String lat;
    @ApiModelProperty("Longitude of the city")
    String lon;
    @ApiModelProperty("City name")
    String city;
    @ApiModelProperty("State")
    String state;
    @ApiModelProperty("Temperature")
    List<Double> temperatures;
}
