package com.weather.entity.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.weather.core.TechnicalFieldsResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
public class WeatherResponse {

    private Long cityId;
    private BigDecimal windSpeed;
    private BigDecimal temperature;
}
