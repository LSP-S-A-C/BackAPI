package com.financeservice.apiadminfinance.controllers;


import com.financeservice.apiadminfinance.converters.SavingSheetsConverter;
import com.financeservice.apiadminfinance.dtos.SavingSheetsDto;
import com.financeservice.apiadminfinance.entity.SavingSheets;
import com.financeservice.apiadminfinance.service.SavingSheetsService;
import com.financeservice.apiadminfinance.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/savingSheets")
public class SavingSheetsController {
    @Autowired
    private SavingSheetsService savingSheetsService;

    @Autowired
    private SavingSheetsConverter savingSheetsConverter;

    @GetMapping("/{savingSheetsId}")
    public ResponseEntity<SavingSheetsDto> findById(@PathVariable("savingSheetsId") Long savingsheetsId) {
        SavingSheets savingSheets = savingSheetsService.findById(savingsheetsId);
        SavingSheetsDto savingSheetsDto = savingSheetsConverter.fromEntity(savingSheets);
        return new WrapperResponse(true, "success", savingSheetsDto).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{savingSheetsId}")
    public ResponseEntity<?> delete(@PathVariable("savingSheetsId") Long savingsheetsId) {
        savingSheetsService.delete(savingsheetsId);
        return new WrapperResponse(true, "success", null)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SavingSheetsDto>> findAll(){
        List<SavingSheets> savingSheets = savingSheetsService.findAll();
        List<SavingSheetsDto> dtoSavingSheets = savingSheetsConverter.fromEntity(savingSheets);

        return new WrapperResponse(true, "success", dtoSavingSheets)
                .createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SavingSheetsDto> create(@RequestBody SavingSheetsDto savingSheets) {
        SavingSheets newSavingSheets = savingSheetsService.save(savingSheetsConverter.fromDTO(savingSheets));
        SavingSheetsDto savingSheetsDto = savingSheetsConverter.fromEntity(newSavingSheets);

        return new WrapperResponse(true, "success", savingSheetsDto)
                .createResponse(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<SavingSheetsDto> update(@RequestBody SavingSheetsDto savingSheets) {
        SavingSheets updateSavingSheets = savingSheetsService.save(savingSheetsConverter.fromDTO(savingSheets));
        SavingSheetsDto savingSheetsDto = savingSheetsConverter.fromEntity(updateSavingSheets);

        return new WrapperResponse(true, "success", savingSheetsDto)
                .createResponse(HttpStatus.OK);
    }
}
