package com.weather.entity.user;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<UserResponse> getAll();
    UserResponse findById(Long id);
    UserResponse create(UserPayload payload);
    UserResponse update(Long id, UserPayload payload);
    Map<Object, Object> generationToken(UserPassword password);
}
