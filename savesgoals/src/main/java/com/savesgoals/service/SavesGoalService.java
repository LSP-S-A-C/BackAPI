package com.savesgoals.service;
import java.util.List;
import java.util.Optional;
import com.savesgoals.entity.SavesGoal;
import com.savesgoals.repository.SavesGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class SavesGoalService {
    @Autowired
	private SavesGoalRepository savesGoalRepository;
	
	public SavesGoal create(SavesGoal savingPlan) {
		return savesGoalRepository.save(savingPlan);
	}

	public SavesGoal update(SavesGoal savingPlan) {
		return savesGoalRepository.save(savingPlan);
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
}