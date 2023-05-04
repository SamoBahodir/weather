package com.weather.entity.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weather.core.TechnicalFields;
import com.weather.entity.city.City;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "weather")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather extends TechnicalFields {
    @Id
    @SequenceGenerator(name = "weather_seq_id", sequenceName = "weather_seq_id", allocationSize = 1)
    @GeneratedValue(generator = "weather_seq_id", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "wind_speed")
    private BigDecimal windSpeed;

    @Column(name = "temperature")
    private BigDecimal temperature;

    @Column(name = "city_id")
    private Long cityId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private City city;
}