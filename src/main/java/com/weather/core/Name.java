package com.weather.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Name {
    private String uz;
    private String oz;
    private String ru;
    private String en;

    @JsonIgnore
    public String getLocale() {
        Locale locale = LocaleContextHolder.getLocale();
        if (locale.equals(Locale.ENGLISH))
            return en;
        else if (locale.equals(Locale.forLanguageTag("uz"))) {
            return uz;
        } else if (locale.equals(Locale.forLanguageTag("oz"))) {
            return oz;
        } else
            return ru;
    }

    @JsonIgnore
    public String getLocale(String lang) {
        switch (lang) {
            case "uz":
                return uz;
            case "oz":
                return oz;
            case "ru":
                return ru;
            default:
                return en;
        }
    }
}
