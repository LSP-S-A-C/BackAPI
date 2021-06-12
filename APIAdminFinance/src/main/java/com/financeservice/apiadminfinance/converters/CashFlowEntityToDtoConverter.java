package com.financeservice.apiadminfinance.converters;

import com.financeservice.apiadminfinance.dtos.CashFlowDto;
import com.financeservice.apiadminfinance.entity.CashFlow;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CashFlowEntityToDtoConverter {
    @Autowired
    private ModelMapper modelMapper;
    public CashFlowDto convertEntityToDto(CashFlow cashFlow) {
        return modelMapper.map(cashFlow, CashFlowDto.class);
    }
    public List<CashFlowDto> convertEntityToDto(List<CashFlow> cashFlows) {
        return cashFlows.stream()
                .map(cashFlow -> convertEntityToDto(cashFlow))
                .collect(Collectors.toList());
    }
}