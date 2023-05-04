
package com.weather.entity.city.dto;

import com.weather.enumeration.Status;
import lombok.Data;

@Data
public class UserCityResponse {
    private Long id;
    private String name;
    private Status status;
}
