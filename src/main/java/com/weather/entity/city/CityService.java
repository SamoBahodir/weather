package com.weather.entity.city;

import com.weather.entity.city.dto.CityPayload;
import com.weather.entity.city.dto.CityResponse;
import com.weather.entity.city.dto.UserCityResponse;
import com.weather.entity.weather.WeatherPayload;

import java.util.List;


public interface CityService {

    List<UserCityResponse> getAll();

    CityResponse create(CityPayload payload , Long cityId);

    CityResponse update(Long id, CityPayload payload);

    CityResponse findById(Long cityId);
}