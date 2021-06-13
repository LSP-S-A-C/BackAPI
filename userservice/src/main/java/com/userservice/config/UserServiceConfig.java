package com.userservice.config;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@Configuration
@PropertySource({"classpath:application.properties"})
public class UserServiceConfig {
    @Value("${savingsplanservice.url}")
    private String savingsPlanServiceUrl;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
