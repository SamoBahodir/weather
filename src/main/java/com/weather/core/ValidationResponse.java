package com.weather.core;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationResponse {
    @Schema(example = "phone", requiredMode = Schema.RequiredMode.REQUIRED)
    private String key;
    @Schema(example = "not be null", requiredMode = Schema.RequiredMode.REQUIRED)
    private String message;

}
