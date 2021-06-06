package com.financeservice.apiadminfinance.controllers;

import com.financeservice.apiadminfinance.converters.CashFlowConverter;
import com.financeservice.apiadminfinance.dtos.CashFlowDto;
import com.financeservice.apiadminfinance.entity.CashFlow;
import com.financeservice.apiadminfinance.service.CashFlowService;
import com.financeservice.apiadminfinance.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cashFlow")
public class CashFlowController {
    @Autowired
    private CashFlowService cashFlowService;

    @Autowired
    private CashFlowConverter cashFlowConverter;

    @GetMapping("/{cashFlowId}")
    public ResponseEntity<CashFlowDto> findById(@PathVariable("cashFlowId") Long cashFlowId) {
        CashFlow cashFlow = cashFlowService.findById(cashFlowId);
        CashFlowDto cashFlowDto = cashFlowConverter.fromEntity(cashFlow);
        return new WrapperResponse(true, "success", cashFlowDto).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{cashFlowId}")
    public ResponseEntity<?> delete(@PathVariable("cashFlowId") Long cashFlowId) {
        cashFlowService.delete(cashFlowId);
        return new WrapperResponse(true, "success", null)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CashFlowDto>> findAll(){
        List<CashFlow> cashFlows = cashFlowService.findAll();
        List<CashFlowDto> dtoCashFlow = cashFlowConverter.fromEntity(cashFlows);

        return new WrapperResponse(true, "success", dtoCashFlow)
                .createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CashFlowDto> create(@RequestBody CashFlowDto cashFlow) {
        CashFlow newCashFlow = cashFlowService.save(cashFlowConverter.fromDTO(cashFlow));
        CashFlowDto cashFlowDto = cashFlowConverter.fromEntity(newCashFlow);

        return new WrapperResponse(true, "success", cashFlowDto)
                .createResponse(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CashFlowDto> update(@RequestBody CashFlowDto cashFlow) {
        CashFlow updateCashFlow = cashFlowService.save(cashFlowConverter.fromDTO(cashFlow));
        CashFlowDto cashFlowDto = cashFlowConverter.fromEntity(updateCashFlow);

        return new WrapperResponse(true, "success", cashFlowDto)
                .createResponse(HttpStatus.OK);
    }
}
