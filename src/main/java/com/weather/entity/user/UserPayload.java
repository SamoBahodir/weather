package com.weather.entity.user;

import com.weather.entity.city.dto.CityPayload;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserPayload {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotBlank
    private String email;
    @NotBlank
    private CityPayload subscribedCities;
}
