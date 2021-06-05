package com.financeservice.apiadminfinance.service;

import com.financeservice.apiadminfinance.entity.SavingSheets;

import java.util.List;

public interface SavingSheetsService {
    SavingSheets findById(Long savingSheetId);
    void delete(Long savingSheetId);
    List<SavingSheets> findAll();
    SavingSheets save(SavingSheets savingSheets);
}
