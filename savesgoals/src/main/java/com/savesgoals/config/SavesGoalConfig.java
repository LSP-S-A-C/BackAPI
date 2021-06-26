package com.savesgoals.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import lombok.Getter;
import org.modelmapper.ModelMapper;
@Getter
@Configuration
@PropertySource({"classpath:application.properties"})
public class SavesGoalConfig {
    @Value("${userservice.url}")
    private String customerServiceUrl;

    @Value("${savingsplanservice.url}")
    private String savingsheetServiceUrl;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
