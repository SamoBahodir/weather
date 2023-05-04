package com.weather.entity.weather;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    Weather findByCityId(Long cityId);
}
