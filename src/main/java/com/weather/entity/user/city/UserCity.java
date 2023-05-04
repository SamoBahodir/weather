package com.weather.entity.user.city;

import com.weather.entity.city.City;
import com.weather.entity.user.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_cities")
public class UserCity {
    @EmbeddedId
    private UserCityId id;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private City city;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;
}
