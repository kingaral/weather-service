package com.akvelon.weather.service.repository;

import com.akvelon.weather.service.model.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long>, JpaSpecificationExecutor<Weather> {
}
