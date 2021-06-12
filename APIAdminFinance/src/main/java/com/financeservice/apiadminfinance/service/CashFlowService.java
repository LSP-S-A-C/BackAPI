package com.financeservice.apiadminfinance.service;

import com.financeservice.apiadminfinance.entity.CashFlow;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CashFlowService {
    CashFlow create(CashFlow cashFlow);

    CashFlow update(CashFlow cashFlow);

    void delete(Long id);

    Optional<CashFlow> listById(Long id);

    List<CashFlow> list(Pageable page);
}
