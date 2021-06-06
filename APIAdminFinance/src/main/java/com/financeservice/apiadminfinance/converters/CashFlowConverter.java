package com.financeservice.apiadminfinance.converters;

import com.financeservice.apiadminfinance.dtos.CashFlowDto;
import com.financeservice.apiadminfinance.entity.CashFlow;

import java.util.List;

public class CashFlowConverter extends AbstractConverter<CashFlow, CashFlowDto>{

    @Override
    public CashFlowDto fromEntity(CashFlow entity) {
        if(entity == null) return null;

        return CashFlowDto.builder()
                .id(entity.getId())
                .color(entity.getColor())
                .amount(entity.getAmount())
                .cashFlowName(entity.getCashFlowName())
                .recurrent(entity.getRecurrent())
                .category(entity.getCategory())
                .build();
    }

    @Override
    public CashFlow fromDTO(CashFlowDto dto) {
        if(dto == null) return null;
        return CashFlow.builder()
                .id(dto.getId())
                .color(dto.getColor())
                .amount(dto.getAmount())
                .cashFlowName(dto.getCashFlowName())
                .recurrent(dto.getRecurrent())
                .category(dto.getCategory())
                .build();
    }
}
