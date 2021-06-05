package com.userservice.config;
import com.userservice.converters.UserConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ConverterConfig {
    @Value("${config.datetimeFormat}")
    private String datetimeFormat;
    @Bean
    public UserConverter getUserConverter(){
        return new UserConverter();
    }
}
