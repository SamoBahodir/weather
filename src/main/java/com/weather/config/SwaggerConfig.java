package com.weather.config;

import com.weather.core.PathConstants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Weather service",
                version = "1.0",
                contact = @Contact(
                        name = "Weather service SUPPORT", email = "turayev.bahodir95@gmail.com"
                ),
                description = "Weather service resources"
        ),
        servers = {
                @Server(url = "http://localhost:${server.port}", description = "Local development"),
        }
)
@SecurityScheme(
        name = SwaggerConfig.BEARER,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "Bearer"
)
public class SwaggerConfig {


    public static final String BEARER = "Authorization";

    @Bean
    public GroupedOpenApi apiV1AdminGroup() {
        return GroupedOpenApi
                .builder()
                .group("Api v1 admin")
                .pathsToMatch(PathConstants.API_V1_ADMIN + "/**").build();
    }

    @Bean
    public GroupedOpenApi apiV1CustomerGroup() {
        return GroupedOpenApi
                .builder()
                .group("Api v1 customer")
                .pathsToMatch(PathConstants.API_V1_CUSTOMER + "/**").build();
    }

}
