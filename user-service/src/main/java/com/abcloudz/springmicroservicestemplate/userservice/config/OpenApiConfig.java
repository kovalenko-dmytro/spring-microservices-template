package com.abcloudz.springmicroservicestemplate.userservice.config;

import com.abcloudz.springmicroservicestemplate.userservice.common.OpenApi;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class OpenApiConfig {

    @Bean
    public OpenAPI customizeOpenAPI() {
        return new OpenAPI()
            .info(info())
            .addSecurityItem(new SecurityRequirement()
                .addList(OpenApi.OPEN_API_SECURITY_SCHEMA_NAME.getValue()))
            .components(new Components()
                .addSecuritySchemes(OpenApi.OPEN_API_SECURITY_SCHEMA_NAME.getValue(), new SecurityScheme()
                    .name(OpenApi.OPEN_API_SECURITY_SCHEMA_NAME.getValue())
                    .type(SecurityScheme.Type.HTTP)
                    .scheme(OpenApi.OPEN_API_SECURITY_SCHEMA.getValue())
                    .bearerFormat(OpenApi.OPEN_API_SECURITY_SCHEMA_BEARER_FORMAT.getValue())));
    }

    private Info info() {
        Info info = new Info();
        info.setTitle(OpenApi.OPEN_API_INFO_TITLE.getValue());
        return info;
    }
}
