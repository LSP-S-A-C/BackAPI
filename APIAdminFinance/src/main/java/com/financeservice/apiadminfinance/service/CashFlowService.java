package com.financeservice.apiadminfinance.service;

import com.financeservice.apiadminfinance.entity.CashFlow;

import java.util.List;

public interface CashFlowService {
    CashFlow findById(Long cashFlowId);
    void delete(Long cashFlowId);
    List<CashFlow> findAll();
    CashFlow save(CashFlow cashFlow);
}
