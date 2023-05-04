package com.weather.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weather.core.TechnicalFields;
import com.weather.entity.city.City;
import com.weather.enumeration.RoleName;
import com.weather.enumeration.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends TechnicalFields {
    @Id
    @GeneratedValue(generator = "user_id_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "user_id_seq",sequenceName = "user_id_seq",allocationSize = 1)
    private Long id;
    @NotNull
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String email;

    @Enumerated(EnumType.STRING)
    private RoleName role;

}
