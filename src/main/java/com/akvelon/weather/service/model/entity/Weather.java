package com.akvelon.weather.service.model.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "weather")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Weather {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    Long id;

    LocalDate date;

    String lat;

    String lon;

    String city;

    String state;

    @Type(type = "jsonb")
    List<Double> temperatures;
}
