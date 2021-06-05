package com.savesgoals.service;
import com.savesgoals.entity.SavesGoal;
import com.savesgoals.entity.SavingPlan;
import com.savesgoals.repository.SavingPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class SavingPlanService {
    @Autowired
	private SavingPlanRepository savingsPlanRepository;
	
	public SavingPlan create(SavingPlan savingPlan) {
		savingPlan.setSavesgoals(new ArrayList<SavesGoal>());
		return savingsPlanRepository.save(savingPlan);
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
	
}
