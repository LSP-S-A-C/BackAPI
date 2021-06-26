package com.savesgoals.service;
import java.util.List;
import java.util.Optional;
import com.savesgoals.entity.SavesGoal;
import com.savesgoals.entity.SavingPlan;
import com.savesgoals.exceptions.GeneralServiceException;
import com.savesgoals.exceptions.NoDataFoundException;
import com.savesgoals.exceptions.ValidateServiceException;
import com.savesgoals.repository.SavesGoalRepository;
import com.savesgoals.validators.SavesGoalsValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class SavesGoalService {
    @Autowired
	private SavesGoalRepository savesGoalRepository;
	
	public SavesGoal create(SavesGoal savesGoal) {
		try {
			SavesGoalsValidator.validate(savesGoal);
			return savesGoalRepository.save(savesGoal);
        } catch (ValidateServiceException | NoDataFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new GeneralServiceException(e.getMessage(), e);
		}	
	}
	public SavesGoal update(SavesGoal savesGoal) {
		return savesGoalRepository.save(savesGoal);
	}
	public void delete(Long id) {
		savesGoalRepository.deleteById(id);
	}
	public Optional<SavesGoal> listById(Long id) {
		return savesGoalRepository.findById(id);
	}
	public List<SavesGoal> list(Pageable page) {
		return savesGoalRepository.findAll(page).toList();
	}
	public List<SavesGoal> listbySavingPlan(Long id, Pageable page) {
		return savesGoalRepository.findBySavingplanNative(id, page).toList();
	}
}