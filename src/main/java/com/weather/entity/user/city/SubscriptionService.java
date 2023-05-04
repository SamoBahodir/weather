package com.weather.entity.user.city;

import com.weather.entity.city.dto.SubscriptionResponse;

import java.util.List;

public interface SubscriptionService {

    void subscribeUser(Long cityId);

    List<SubscriptionResponse> getUserSubscriptions();
}
