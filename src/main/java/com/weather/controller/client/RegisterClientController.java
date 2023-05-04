package com.weather.controller.client;

import com.weather.config.SwaggerConfig;
import com.weather.core.PathConstants;
import com.weather.entity.city.CityService;
import com.weather.entity.city.dto.SubscriptionResponse;
import com.weather.entity.city.dto.UserCityResponse;
import com.weather.entity.user.UserPassword;
import com.weather.entity.user.UserPayload;
import com.weather.entity.user.UserResponse;
import com.weather.entity.user.UserService;
import com.weather.entity.user.city.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(PathConstants.API_V1_CUSTOMER)
public class RegisterClientController {

    private final UserService userService;
    private final CityService cityService;
    private final SubscriptionService subscriptionService;

    @PostMapping("/register")
    public UserResponse create(@RequestBody @Valid UserPayload userPayload) {
        log.info("User registration: {}", userPayload);
        return userService.create(userPayload);
    }

    @PostMapping("/token")
    public Map<Object, Object> login(@RequestBody @Valid UserPassword password) {
        return userService.generationToken(password);
    }

    @GetMapping("/cities")
    @Operation(security = {@SecurityRequirement(name = SwaggerConfig.BEARER)}, summary = "list ")
    public List<UserCityResponse> cities() {
        return cityService.getAll();
    }

    @GetMapping("/subscriptions")
    @Operation(security = {@SecurityRequirement(name = SwaggerConfig.BEARER)}, summary = "subscriptions")
    public List<SubscriptionResponse> subscriptions() {
        return subscriptionService.getUserSubscriptions();
    }

    @PostMapping("/{cityId}/subscribe")
    @Operation(security = {@SecurityRequirement(name = SwaggerConfig.BEARER)}, summary = "subscribe")
    public void subscribe(@PathVariable Long cityId) {
        subscriptionService.subscribeUser(cityId);
    }
}