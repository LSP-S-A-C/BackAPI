package com.financeservice.apiadminfinance.converters;

import com.financeservice.apiadminfinance.dtos.SavingSheetsDto;
import com.financeservice.apiadminfinance.entity.SavingSheets;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class SavingSheetsEntityToDtoConverter {
    @Autowired
    private ModelMapper modelMapper;
    public SavingSheetsDto convertEntityToDto(SavingSheets savingSheets) {
        return modelMapper.map(savingSheets, SavingSheetsDto.class);
    }
    public List<SavingSheetsDto> convertEntityToDto(List<SavingSheets> savingSheet) {
        return savingSheet.stream()
                .map(savingSheets -> convertEntityToDto(savingSheets))
                .collect(Collectors.toList());
    }
}
