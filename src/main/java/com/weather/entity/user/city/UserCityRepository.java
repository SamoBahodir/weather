package com.weather.entity.user.city;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCityRepository extends JpaRepository<UserCity, UserCityId> {
    List<UserCity> findByUserId(Long userId);
}
