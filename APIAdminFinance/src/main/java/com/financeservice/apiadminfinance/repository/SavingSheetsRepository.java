package com.financeservice.apiadminfinance.repository;
import com.financeservice.apiadminfinance.entity.SavingSheets;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SavingSheetsRepository extends JpaRepository<SavingSheets, Long> {
    Page<SavingSheets> findByIdSavingPlan(String savingplanId, Pageable page);
}
