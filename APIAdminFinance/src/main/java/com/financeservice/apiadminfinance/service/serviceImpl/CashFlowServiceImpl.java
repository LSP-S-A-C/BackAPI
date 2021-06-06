package com.financeservice.apiadminfinance.service.serviceImpl;


import com.financeservice.apiadminfinance.entity.CashFlow;
import com.financeservice.apiadminfinance.exceptions.GeneralServiceException;
import com.financeservice.apiadminfinance.exceptions.NoDataFoundException;
import com.financeservice.apiadminfinance.exceptions.ValidateServiceException;
import com.financeservice.apiadminfinance.repository.CashFlowRepository;
import com.financeservice.apiadminfinance.service.CashFlowService;
import com.financeservice.apiadminfinance.validators.CashFlowValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class CashFlowServiceImpl implements CashFlowService {

    @Autowired
    private CashFlowRepository cashFlowRepository;

    public CashFlow findById(Long cashFlowId){
        try {
            log.debug("findById => " + cashFlowId);
            CashFlow cashFlow = cashFlowRepository.findById(cashFlowId)
                    .orElseThrow(() -> new NoDataFoundException("No existe el flujo de efectivo"));
            return cashFlow;
        } catch(ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public void delete(Long cashFlowId) {
        try {
            CashFlow cashFlow = cashFlowRepository.findById(cashFlowId)
                    .orElseThrow(() -> new NoDataFoundException("No existe el flujo de efectivo"));
            cashFlowRepository.delete(cashFlow);
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    public List<CashFlow> findAll(){
        try {
            List<CashFlow> cashFlows = cashFlowRepository.findAll();
            return cashFlows;
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public CashFlow save(CashFlow cashFlow) {
        try {
            CashFlowValidator.save(cashFlow);

            if(cashFlow.getId() == null) {
                CashFlow newCashFlow = cashFlowRepository.save(cashFlow);
                return newCashFlow;
            }

            CashFlow exitCashFlow = cashFlowRepository.findById(cashFlow.getId())
                    .orElseThrow(() -> new NoDataFoundException("No existe flujo de efectivo"));

            exitCashFlow.setCashFlowName(cashFlow.getCashFlowName());
            exitCashFlow.setCategory(cashFlow.getCategory());
            exitCashFlow.setAmount(cashFlow.getAmount());
            exitCashFlow.setColor(cashFlow.getColor());
            exitCashFlow.setRecurrent(cashFlow.getRecurrent());


            cashFlowRepository.save(exitCashFlow);

            return exitCashFlow;
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }

    }

}
