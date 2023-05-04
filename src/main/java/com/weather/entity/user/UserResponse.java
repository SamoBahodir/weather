package com.weather.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.weather.core.TechnicalFieldsResponse;
import com.weather.entity.city.City;
import com.weather.entity.city.CityRepository;
import com.weather.enumeration.RoleName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse extends TechnicalFieldsResponse {
    private CityRepository repository;
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private RoleName role;
    private Date deletedAt;
}
