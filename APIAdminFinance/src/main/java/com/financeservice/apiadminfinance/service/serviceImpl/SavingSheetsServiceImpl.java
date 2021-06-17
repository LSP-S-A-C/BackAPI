package com.financeservice.apiadminfinance.service.serviceImpl;

import com.financeservice.apiadminfinance.entity.SavingSheets;
import com.financeservice.apiadminfinance.exceptions.GeneralServiceException;
import com.financeservice.apiadminfinance.exceptions.NoDataFoundException;
import com.financeservice.apiadminfinance.exceptions.ValidateServiceException;
import com.financeservice.apiadminfinance.repository.SavingSheetsRepository;
import com.financeservice.apiadminfinance.service.SavingSheetsService;
import com.financeservice.apiadminfinance.validators.SavingSheetsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingSheetsServiceImpl implements SavingSheetsService {

    @Autowired
    private SavingSheetsRepository savingSheetsRepository;

    public SavingSheets create(SavingSheets savingSheets) {
        try {
            SavingSheetsValidator.validate(savingSheets);
            return savingSheetsRepository.save(savingSheets);
        } catch (ValidateServiceException | NoDataFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    public SavingSheets update(SavingSheets savingSheets) {
        return savingSheetsRepository.save(savingSheets);
    }

    public void delete(Long id) {
        savingSheetsRepository.deleteById(id);
    }

    public Optional<SavingSheets> listById(Long id) {
        return savingSheetsRepository.findById(id);
    }

    public List<SavingSheets> list(Pageable page) {
        return savingSheetsRepository.findAll(page).toList();
    }
}