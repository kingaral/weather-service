package com.akvelon.weather.service.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@NoArgsConstructor
@ApiModel("Dto of weather")
@FieldDefaults(level = PRIVATE)
public class WeatherDto {
    @ApiModelProperty("Id of the weather information")
    private
    Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty("Day of the weather information")
    private
    Date date;
    @ApiModelProperty("Latitude of the city")
    private
    String lat;
    @ApiModelProperty("Longitude of the city")
    private
    String lon;
    @ApiModelProperty("City name")
    private
    String city;
    @ApiModelProperty("State")
    private
    String state;
    @ApiModelProperty("Temperature")
    private
    List<Double> temperatures;

    public WeatherDto(Date date, Float lat, Float lon, String city, String state, List<Double> temperatures) {
        this.date = date;
        this.lat = lat.toString();
        this.lon = lon.toString();
        this.city = city;
        this.state = state;
        this.temperatures = temperatures;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof WeatherDto)) return false;
        final WeatherDto other = (WeatherDto) o;
        final Object this$lat = this.getLat();
        final Object other$lat = other.getLat();
        if (this$lat == null ? other$lat != null : !this$lat.equals(other$lat)) return false;
        final Object this$lon = this.getLon();
        final Object other$lon = other.getLon();
        if (this$lon == null ? other$lon != null : !this$lon.equals(other$lon)) return false;
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
        final Object this$state = this.getState();
        final Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) return false;
        final Object this$temperatures = this.getTemperatures();
        final Object other$temperatures = other.getTemperatures();
        if (this$temperatures == null ? other$temperatures != null : !this$temperatures.equals(other$temperatures))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $lat = this.getLat();
        result = result * PRIME + ($lat == null ? 43 : $lat.hashCode());
        final Object $lon = this.getLon();
        result = result * PRIME + ($lon == null ? 43 : $lon.hashCode());
        final Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        final Object $state = this.getState();
        result = result * PRIME + ($state == null ? 43 : $state.hashCode());
        final Object $temperatures = this.getTemperatures();
        result = result * PRIME + ($temperatures == null ? 43 : $temperatures.hashCode());
        return result;
    }
}
