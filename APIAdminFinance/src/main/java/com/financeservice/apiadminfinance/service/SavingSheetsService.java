package com.financeservice.apiadminfinance.service;

import com.financeservice.apiadminfinance.entity.SavingSheets;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SavingSheetsService {
    SavingSheets create(SavingSheets savingSheets);

    SavingSheets update(SavingSheets savingSheets);
    void delete(Long id);
    Optional<SavingSheets> listById(Long id);
    List<SavingSheets> list(Pageable page);
    List<SavingSheets> listbySPid(String savingPlanId, Pageable page);
}
