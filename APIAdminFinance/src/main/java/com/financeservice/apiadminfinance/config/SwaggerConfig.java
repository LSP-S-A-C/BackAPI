package com.financeservice.apiadminfinance.config;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Dirección para ver swagger
//http://localhost:8082/api/v1/swagger-ui.html

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.financeservice.apiadminfinance.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Admin Finances API",
                "Microservicio para admnistrar las finanzas de la aplicación LifeStylePlanner",
                "1.0",
                "TODO",
                new Contact("LifeStylePlanner", "https://elenadanielass.wixsite.com/lsp4", "UPCLSPE4@GMAIL.COM"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}