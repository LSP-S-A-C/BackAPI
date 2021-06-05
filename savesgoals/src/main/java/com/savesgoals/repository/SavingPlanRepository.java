package com.savesgoals.repository;

import com.savesgoals.entity.SavingPlan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingPlanRepository extends JpaRepository<SavingPlan, Long> {
    
}
