package com.savesgoals.repository;

import com.savesgoals.entity.SavesGoal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SavesGoalRepository extends JpaRepository<SavesGoal, Long> {
    
}
