package com.weather.entity.city.dto;

import com.weather.entity.weather.WeatherPayload;
import com.weather.enumeration.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityPayload {
    private Long parentId;
    private String name;
    private WeatherPayload weather;

}
