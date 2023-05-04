package com.weather.entity.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserPassword {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
