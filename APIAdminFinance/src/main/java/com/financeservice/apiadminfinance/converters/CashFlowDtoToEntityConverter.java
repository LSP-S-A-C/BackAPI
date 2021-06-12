package com.financeservice.apiadminfinance.converters;

import com.financeservice.apiadminfinance.dtos.CashFlowDto;
import com.financeservice.apiadminfinance.entity.CashFlow;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CashFlowDtoToEntityConverter{
    @Autowired
    private ModelMapper modelMapper;
    public CashFlow convertDtoToEntity(CashFlowDto cashFlowDto) {
        return modelMapper.map(cashFlowDto, CashFlow.class);
    }
    public List<CashFlow> convertDtoToEntity(List<CashFlowDto> cashFlowDtos) {
        return cashFlowDtos.stream()
                .map(cashFlowDto -> convertDtoToEntity(cashFlowDto))
                .collect(Collectors.toList());
    }
}

