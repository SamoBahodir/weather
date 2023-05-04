package com.weather.entity.user.city;

import com.weather.entity.city.CityMapper;
import com.weather.entity.city.dto.SubscriptionResponse;
import com.weather.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final UserCityRepository userCityRepository;
    private final CityMapper cityMapper;

    @Override
    public void subscribeUser(Long cityId) {
        UserDetailsImpl principal = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = principal.getUserId();

        UserCity city = new UserCity();
        city.setId(new UserCityId(cityId, userId));
        userCityRepository.save(city);
    }

    @Override
    public List<SubscriptionResponse> getUserSubscriptions() {
        UserDetailsImpl principal = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = principal.getUserId();
        return userCityRepository
                .findByUserId(userId)
                .stream()
                .map(item->cityMapper.toUserDto(item.getCity()))
                .collect(Collectors.toList());
    }
}
