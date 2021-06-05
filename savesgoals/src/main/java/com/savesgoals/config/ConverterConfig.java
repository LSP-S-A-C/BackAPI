package com.savesgoals.config;

import com.savesgoals.converters.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfig {
    @Bean
    public SavingsPlanConverter getSavingsPlanConverter(){
        return new SavingsPlanConverter();
    }
    @Bean
    public SavesGoalsConverter getSavesGoalConverter(){
        return new SavesGoalsConverter();
    }
}