package com.weather.controller.admin;

import com.weather.config.SwaggerConfig;
import com.weather.core.PathConstants;
import com.weather.entity.user.UserPayload;
import com.weather.entity.user.UserResponse;
import com.weather.entity.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(PathConstants.API_V1_ADMIN + "/users")
public class UserAdminController {
    private final UserService userService;

    @GetMapping("/{userId}/details")
    @Operation(security = {@SecurityRequirement(name = SwaggerConfig.BEARER)}, summary = "get by id")
    public UserResponse details(@PathVariable Long userId) {
        log.debug("get by id {}", userId);
        return userService.findById(userId);
    }

    @GetMapping
    @Operation(security = {@SecurityRequirement(name = SwaggerConfig.BEARER)}, summary = "list")
    public List<UserResponse> getList() {
        return userService.getAll();
    }

    @PutMapping("/{userId}")
    @Operation(security = {@SecurityRequirement(name = SwaggerConfig.BEARER)}, summary = "update")
    public UserResponse update(@PathVariable Long userId,
                               @Valid @RequestBody UserPayload payload) {
        log.debug("user update {} {} ", userId, payload);
        return userService.update(userId, payload);
    }
}