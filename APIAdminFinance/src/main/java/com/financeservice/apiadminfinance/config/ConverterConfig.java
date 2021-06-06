package com.financeservice.apiadminfinance.config;
import com.financeservice.apiadminfinance.converters.CashFlowConverter;
import com.financeservice.apiadminfinance.converters.CategoryConverter;
import com.financeservice.apiadminfinance.converters.SavingSheetsConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ConverterConfig {
    @Bean
    public SavingSheetsConverter getSavingSheetsConverter(){
        return new SavingSheetsConverter();
    }
    @Bean
    public CategoryConverter getCategoryConverter(){
        return new CategoryConverter();
    }

    @Bean
    public CashFlowConverter getCashFlowConverter(){
        return new CashFlowConverter();
    }

}
