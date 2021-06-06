package com.financeservice.apiadminfinance.converters;

import com.financeservice.apiadminfinance.dtos.SavingSheetsDto;
import com.financeservice.apiadminfinance.entity.SavingSheets;

public class SavingSheetsConverter extends AbstractConverter<SavingSheets, SavingSheetsDto> {

    @Override
    public SavingSheetsDto fromEntity(SavingSheets entity) {
        if(entity == null) return null;

        return SavingSheetsDto.builder()
                .id(entity.getId())
                .idSavingPlan(entity.getIdSavingPlan())
                .period(entity.getPeriod())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .savingSheetsName(entity.getSavingSheetsName())
                .active(entity.getActive())
                .categories(entity.getCategories())
                .build();
    }

    @Override
    public SavingSheets fromDTO(SavingSheetsDto dto) {
        if(dto == null) return null;
        return SavingSheets.builder()
                .id(dto.getId())
                .idSavingPlan(dto.getIdSavingPlan())
                .period(dto.getPeriod())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .savingSheetsName(dto.getSavingSheetsName())
                .active(dto.getActive())
                .categories(dto.getCategories())
                .build();
    }

}
