package com.weather.entity.user.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class UserCityId implements Serializable {
    @Column(name = "city_id")
    private Long cityId;
    @Column(name = "user_id")
    private Long userId;
}
