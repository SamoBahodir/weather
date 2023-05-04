package com.weather.entity.city;

import com.weather.entity.city.dto.CityPayload;
import com.weather.entity.city.dto.CityResponse;
import com.weather.entity.city.dto.SubscriptionResponse;
import com.weather.entity.city.dto.UserCityResponse;
import com.weather.entity.weather.WeatherPayload;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CityMapper {

    void toEntity(@MappingTarget City city, CityPayload payload);
    void toEntityWeather(@MappingTarget City city, WeatherPayload payload);

    CityResponse toDto(City city);

    UserCityResponse toUserCityDto(City city);

    SubscriptionResponse toUserDto(City city);
}
