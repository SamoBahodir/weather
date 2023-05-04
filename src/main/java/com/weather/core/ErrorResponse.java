package com.weather.core;

import ch.qos.logback.core.status.ErrorStatus;
import com.weather.enumeration.ResponseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    @Schema(example = "")
    private String path;
    private ResponseStatus status;
    private List<ValidationResponse> validation;
}
