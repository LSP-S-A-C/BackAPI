package com.financeservice.apiadminfinance.controllers;


import com.financeservice.apiadminfinance.converters.SavingSheetsDtoToEntityConverter;
import com.financeservice.apiadminfinance.converters.SavingSheetsEntityToDtoConverter;
import com.financeservice.apiadminfinance.dtos.SavingSheetsDto;
import com.financeservice.apiadminfinance.entity.SavingSheets;
import com.financeservice.apiadminfinance.service.SavingSheetsService;
import com.financeservice.apiadminfinance.utils.WrapperResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api
@RestController
@RequestMapping("/savingSheets")
public class SavingSheetsController {
    @Autowired
    private SavingSheetsService savingSheetsService;

    @Autowired
    private SavingSheetsEntityToDtoConverter converter1;

    @Autowired
    private SavingSheetsDtoToEntityConverter converter2;

    @ApiOperation(value = " ")
    @GetMapping
    public ResponseEntity<WrapperResponse<List<SavingSheetsDto>>> findAll(
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<SavingSheets> savingSheets = savingSheetsService.list(page);
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(savingSheets)).createResponse();
    }

    @ApiOperation(value = " ")
    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<SavingSheetsDto>> findById(@PathVariable(name="id") Long id){
        SavingSheets savingSheets = savingSheetsService.listById(id).get();
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(savingSheets)).createResponse();
    }

    @ApiOperation(value = " ")
    @PostMapping
    public ResponseEntity<WrapperResponse<SavingSheetsDto>> create(@RequestBody SavingSheetsDto savingSheets){
        SavingSheets newSavingSheets = savingSheetsService.create(converter2.convertDtoToEntity(savingSheets));
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(newSavingSheets)).createResponse();
    }

    @ApiOperation(value = " ")
    @PutMapping
    public ResponseEntity<WrapperResponse<SavingSheetsDto>> update(@RequestBody SavingSheetsDto savingSheets){
        SavingSheets newSavingSheets = savingSheetsService.update(converter2.convertDtoToEntity(savingSheets));
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(newSavingSheets)).createResponse();
    }

    @ApiOperation(value = " ")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
        savingSheetsService.delete(id);
        return new WrapperResponse<>(true, "success", null).createResponse();
    }

}
