package com.weather.entity.city;

import com.weather.entity.city.dto.CityPayload;
import com.weather.entity.city.dto.CityResponse;
import com.weather.entity.city.dto.UserCityResponse;
import com.weather.enumeration.ResponseStatus;
import com.weather.enumeration.Status;
import com.weather.exception.RestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityMapper cityMapper;
    private final CityRepository cityRepository;

    public City getById(Long id) {
        return cityRepository.getById(id);
    }

    public CityResponse create(CityPayload payload, Long cityId) {
        City city = getById(cityId);
        cityMapper.toEntity(city, payload);
        return cityMapper.toDto(cityRepository.save(city));
    }

    public CityResponse update(Long id, CityPayload payload) {
        City city = getById(id);
        cityMapper.toEntity(city, payload);
        return cityMapper.toDto(cityRepository.save(city));

    }

    @Override
    public CityResponse findById(Long cityId) {
        return cityRepository.findById(cityId).map(cityMapper::toDto)
                .orElseThrow(() -> new RestException(ResponseStatus.CITY_NOT_FOUND));
    }

    public List<UserCityResponse> getAll() {
        return cityRepository
                .findAll()
                .stream()
                .map(cityMapper::toUserCityDto)
                .collect(Collectors.toList());
    }
}
