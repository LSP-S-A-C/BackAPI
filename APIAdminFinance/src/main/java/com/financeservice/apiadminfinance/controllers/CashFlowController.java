package com.financeservice.apiadminfinance.controllers;

import com.financeservice.apiadminfinance.converters.CashFlowDtoToEntityConverter;
import com.financeservice.apiadminfinance.converters.CashFlowEntityToDtoConverter;
import com.financeservice.apiadminfinance.dtos.CashFlowDto;
import com.financeservice.apiadminfinance.entity.CashFlow;
import com.financeservice.apiadminfinance.service.CashFlowService;
import com.financeservice.apiadminfinance.utils.WrapperResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cashFlow")
public class CashFlowController {
    @Autowired
    private CashFlowService cashFlowService;

    @Autowired
    private CashFlowEntityToDtoConverter converter1;

    @Autowired
    private CashFlowDtoToEntityConverter converter2;

    @ApiOperation(value = " ")
    @GetMapping
    public ResponseEntity<WrapperResponse<List<CashFlowDto>>> findAll(
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<CashFlow> cashFlows = cashFlowService.list(page);
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(cashFlows)).createResponse();
    }

    @ApiOperation(value = " ")
    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<CashFlowDto>> findById(@PathVariable(name="id") Long id){
        CashFlow cashFlows = cashFlowService.listById(id).get();
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(cashFlows)).createResponse();
    }

    @ApiOperation(value = " ")
    @PostMapping
    public ResponseEntity<WrapperResponse<CashFlowDto>> create(@RequestBody CashFlowDto cashFlow){
        CashFlow newCashFlows = cashFlowService.create(  converter2.convertDtoToEntity(cashFlow));
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(newCashFlows)).createResponse();
    }

    @ApiOperation(value = " ")
    @PutMapping
    public ResponseEntity<WrapperResponse<CashFlowDto>> update(@RequestBody CashFlowDto cashFlow){
        CashFlow newCashFlow = cashFlowService.update(converter2.convertDtoToEntity(cashFlow));
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(newCashFlow)).createResponse();
    }

    @ApiOperation(value = " ")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
        cashFlowService.delete(id);
        return new WrapperResponse<>(true, "success", null).createResponse();
    }
}
