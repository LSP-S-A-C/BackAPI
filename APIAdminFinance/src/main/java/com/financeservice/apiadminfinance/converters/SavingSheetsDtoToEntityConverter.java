package com.financeservice.apiadminfinance.converters;

import com.financeservice.apiadminfinance.dtos.SavingSheetsDto;
import com.financeservice.apiadminfinance.entity.SavingSheets;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SavingSheetsDtoToEntityConverter {

    @Autowired
    private ModelMapper modelMapper;
    public SavingSheets convertDtoToEntity(SavingSheetsDto savingSheetsDto) {
        return modelMapper.map(savingSheetsDto, SavingSheets.class);
    }
    public List<SavingSheets> convertDtoToEntity(List<SavingSheetsDto> savingSheetsDtos) {
        return savingSheetsDtos.stream()
                .map(savingSheetsDto -> convertDtoToEntity(savingSheetsDto))
                .collect(Collectors.toList());
    }
}
