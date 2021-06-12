package com.financeservice.apiadminfinance.config;

import com.financeservice.apiadminfinance.converters.*;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource({"classpath:application.properties"})
public class ConverterConfig {
    /*@Bean
    public SavingSheetsDtoToEntityConverter getSavingSheetsDtoToEntityConverter(){
        return new SavingSheetsDtoToEntityConverter();
    }
    @Bean
    public SavingSheetsEntityToDtoConverter getSavingSheetsEntityToDtoConverter(){
        return new SavingSheetsEntityToDtoConverter();
    }
    @Bean
    public CategoryEntityToDtoConverter getCategoryEntityToDtoConverter(){
        return new CategoryEntityToDtoConverter();
    }
    @Bean
    public CategoryDtoToEntityConverter getCategoryDtoToEntityConverter(){
        return new CategoryDtoToEntityConverter();
    }
    @Bean
    public CashFlowDtoToEntityConverter getCashFlowDtoToEntityConverter(){
        return new CashFlowDtoToEntityConverter();
    }
    @Bean
    public CashFlowEntityToDtoConverter getCashFlowEntityToDtoConverter(){
        return new CashFlowEntityToDtoConverter();
    }*/
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
