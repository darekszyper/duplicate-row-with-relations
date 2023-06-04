package com.test.dariuszszyperek.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI serverOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Test")
                        .version("1.0")
                        .description("Api służące do kopiowania użytkownika"));
    }
}
