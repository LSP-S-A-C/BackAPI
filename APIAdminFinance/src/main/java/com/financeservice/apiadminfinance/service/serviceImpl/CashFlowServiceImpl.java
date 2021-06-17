package com.financeservice.apiadminfinance.service.serviceImpl;


import com.financeservice.apiadminfinance.entity.CashFlow;
import com.financeservice.apiadminfinance.exceptions.GeneralServiceException;
import com.financeservice.apiadminfinance.exceptions.NoDataFoundException;
import com.financeservice.apiadminfinance.exceptions.ValidateServiceException;
import com.financeservice.apiadminfinance.repository.CashFlowRepository;
import com.financeservice.apiadminfinance.service.CashFlowService;
import com.financeservice.apiadminfinance.validators.CashFlowValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CashFlowServiceImpl implements CashFlowService {

    @Autowired
    private CashFlowRepository cashFlowRepository;

    public CashFlow create(CashFlow cashFlow) {
        try {
            CashFlowValidator.validate(cashFlow);
            return cashFlowRepository.save(cashFlow);
        } catch (ValidateServiceException | NoDataFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    public CashFlow update(CashFlow cashFlow) {
        return cashFlowRepository.save(cashFlow);
    }

    public void delete(Long id) {
        cashFlowRepository.deleteById(id);
    }

    public Optional<CashFlow> listById(Long id) {
        return cashFlowRepository.findById(id);
    }

    public List<CashFlow> list(Pageable page) {
        return cashFlowRepository.findAll(page).toList();
    }

}
