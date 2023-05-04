package com.weather.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseStatus {
    USER_NOT_FOUND(1, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    USER_ALREADY_EXIST(2, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    CITY_NOT_FOUND(3, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    USER_PASSWORD_LESS(4, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    WEATHER_NOT_FOUND(5, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    VALIDATION_ERROR(6, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    UNAUTHORIZED(7, MessageType.ERROR, HttpStatus.UNAUTHORIZED),
    FORBIDDEN(8, MessageType.ERROR, HttpStatus.FORBIDDEN),
    INTERNAL_SERVER_ERROR(9, MessageType.ERROR, HttpStatus.INTERNAL_SERVER_ERROR);


    private final Integer status;
    private final MessageType messageType;
    private final HttpStatus httpStatus;
}
