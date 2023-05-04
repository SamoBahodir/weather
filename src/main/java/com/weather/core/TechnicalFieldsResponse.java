package com.weather.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weather.enumeration.Status;
import lombok.Data;

import java.util.Date;

@Data
public class TechnicalFieldsResponse {
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Asia/Tashkent")
    public Date createdAt;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Asia/Tashkent")
    public Date updatedAt;
    public Status status;
}
