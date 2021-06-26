package com.savesgoals.repository;

import com.savesgoals.entity.SavesGoal;
import com.savesgoals.entity.SavingPlan;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface SavesGoalRepository extends JpaRepository<SavesGoal, Long> {
    @Query(value = "SELECT * FROM ahorros.saves_goals where savingplan_id = ?1", nativeQuery  = true)
    Page<SavesGoal> findBySavingplanNative(Long id, Pageable page);

}
