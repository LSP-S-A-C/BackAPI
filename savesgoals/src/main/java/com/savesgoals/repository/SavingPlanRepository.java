package com.savesgoals.repository;

import com.savesgoals.entity.SavingPlan;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingPlanRepository extends JpaRepository<SavingPlan, Long> {
    Page<SavingPlan> findByUserId(String userId, Pageable page);
}
