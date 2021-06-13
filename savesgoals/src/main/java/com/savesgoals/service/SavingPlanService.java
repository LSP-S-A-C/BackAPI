package com.savesgoals.service;
import com.savesgoals.entity.SavingPlan;
import com.savesgoals.exceptions.GeneralServiceException;
import com.savesgoals.exceptions.NoDataFoundException;
import com.savesgoals.exceptions.ValidateServiceException;
import com.savesgoals.repository.SavingPlanRepository;
import com.savesgoals.validators.SavingPlanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class SavingPlanService {
    @Autowired
	private SavingPlanRepository savingsPlanRepository;
	public SavingPlan create(SavingPlan savingPlan) {
		try {
			SavingPlanValidator.validate(savingPlan);
			return savingsPlanRepository.save(savingPlan);
        } catch (ValidateServiceException | NoDataFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new GeneralServiceException(e.getMessage(), e);
		}	
	}

	public SavingPlan update(SavingPlan savingPlan) {
		return savingsPlanRepository.save(savingPlan);
	}

	public void delete(Long id) {
		savingsPlanRepository.deleteById(id);
	}

	public Optional<SavingPlan> listById(Long id) {
		return savingsPlanRepository.findById(id);
	}
	
	public List<SavingPlan> list(Pageable page) {
		return savingsPlanRepository.findAll(page).toList();
	}

	public List<SavingPlan> listByUserId(String userId, Pageable page) {
		return savingsPlanRepository.findByUserId(userId, page).toList();
	}
}
