package com.weather.entity.city.dto;

import com.weather.entity.weather.UserWeatherResponse;
import lombok.Data;

@Data
public class SubscriptionResponse {
    private Long id;
    private String name;
    private UserWeatherResponse weather;
}
