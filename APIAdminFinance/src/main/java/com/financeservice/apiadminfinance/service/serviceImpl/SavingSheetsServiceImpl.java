package com.financeservice.apiadminfinance.service.serviceImpl;


import com.financeservice.apiadminfinance.entity.SavingSheets;
import com.financeservice.apiadminfinance.exceptions.GeneralServiceException;
import com.financeservice.apiadminfinance.exceptions.NoDataFoundException;
import com.financeservice.apiadminfinance.exceptions.ValidateServiceException;
import com.financeservice.apiadminfinance.repository.SavingSheetsRepository;
import com.financeservice.apiadminfinance.service.SavingSheetsService;
import com.financeservice.apiadminfinance.validators.SavingSheetsValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class SavingSheetsServiceImpl implements SavingSheetsService {

    @Autowired
    private SavingSheetsRepository savingSheetsRepository;

    @Override
    public SavingSheets findById(Long savingSheetId){
        try {
            log.debug("findById => " + savingSheetId);
            SavingSheets savingSheets = savingSheetsRepository.findById(savingSheetId)
                    .orElseThrow(() -> new NoDataFoundException("No existe la Hoja de ahorros"));
            return savingSheets;
        } catch(ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public void delete(Long savingSheetId) {
        try {
            SavingSheets savingSheets = savingSheetsRepository.findById(savingSheetId)
                    .orElseThrow(() -> new NoDataFoundException("No existe el producto"));
            savingSheetsRepository.delete(savingSheets);
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<SavingSheets> findAll(){
        try {
            List<SavingSheets> savingSheets = savingSheetsRepository.findAll();
            return savingSheets;
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public SavingSheets save(SavingSheets savingSheets) {
        try {
            SavingSheetsValidator.save(savingSheets);

            if(savingSheets.getId() == null) {
                SavingSheets newSavingSheets = savingSheetsRepository.save(savingSheets);
                return newSavingSheets;
            }

            SavingSheets exitSavingSheets = savingSheetsRepository.findById(savingSheets.getId())
                    .orElseThrow(() -> new NoDataFoundException("No existe el producto"));

            exitSavingSheets.setSavingSheetsName(savingSheets.getSavingSheetsName());
            exitSavingSheets.setActive(savingSheets.getActive());
            exitSavingSheets.setEndDate(savingSheets.getEndDate());
            exitSavingSheets.setStartDate(savingSheets.getStartDate());
            exitSavingSheets.setPeriod(savingSheets.getPeriod());
            exitSavingSheets.setCategories(savingSheets.getCategories());
            exitSavingSheets.setIdSavingPlan(savingSheets.getIdSavingPlan());


            savingSheetsRepository.save(exitSavingSheets);

            return exitSavingSheets;
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }

    }
}
