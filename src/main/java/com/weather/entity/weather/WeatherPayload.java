package com.weather.entity.weather;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WeatherPayload {

    private BigDecimal windSpeed;
    private BigDecimal temperature;
}
