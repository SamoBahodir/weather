package com.weather.entity.city.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weather.core.TechnicalFieldsResponse;
import com.weather.entity.weather.Weather;
import com.weather.entity.weather.WeatherResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class CityResponse extends TechnicalFieldsResponse {
    private Long id;
    private String name;
    private Long parentId;
private Weather weather;}
