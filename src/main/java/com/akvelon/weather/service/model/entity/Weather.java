package com.akvelon.weather.service.model.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "weather")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Weather {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    Long id;

    Date date;

    String lat;

    String lon;

    String city;

    String state;

    @Type(type = "jsonb")
    List<Double> temperatures;
}
