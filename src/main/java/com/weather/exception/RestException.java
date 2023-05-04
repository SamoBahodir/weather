package com.weather.exception;

import com.weather.enumeration.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestException extends RuntimeException {
    private final ResponseStatus status;
}
