package com.weather.controller.admin;

import com.weather.core.PathConstants;
import com.weather.config.SwaggerConfig;
import com.weather.entity.city.CityService;
import com.weather.entity.city.dto.CityPayload;
import com.weather.entity.city.dto.CityResponse;
import com.weather.entity.city.dto.UserCityResponse;
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
@RequestMapping(PathConstants.API_V1_ADMIN + "/cities")
public class CityAdminController {

    private final CityService cityService;

    @GetMapping("/{id}")
    @Operation(security = {@SecurityRequirement(name = SwaggerConfig.BEARER)}, summary = "get by id ")
    public CityResponse getById(@PathVariable Long id) {
        log.debug("city get by id {}", id);
        return cityService.findById(id);
    }

    @GetMapping
    @Operation(security = {@SecurityRequirement(name = SwaggerConfig.BEARER)}, summary = "list")
    public List<UserCityResponse> list() {
        return cityService.getAll();
    }

    @PostMapping("/{cityId}/weather")
    @Operation(security = {@SecurityRequirement(name = SwaggerConfig.BEARER)}, summary = "create ")
    public CityResponse create(@RequestBody @Valid CityPayload payload, @PathVariable Long cityId) {
        log.debug("city create {} ", payload);
        return cityService.create(payload, cityId);
    }

    @PutMapping("/{cityId}")
    @Operation(security = {@SecurityRequirement(name = SwaggerConfig.BEARER)}, summary = "update")
    public CityResponse update(@PathVariable Long cityId,
                               @RequestBody @Valid CityPayload payload) {
        log.debug("city update {} {} ", cityId, payload);
        return cityService.update(cityId, payload);
    }
}