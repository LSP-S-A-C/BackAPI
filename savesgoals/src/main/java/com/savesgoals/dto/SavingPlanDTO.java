package com.savesgoals.dto;
import java.math.BigDecimal;
import java.util.List;
import com.savesgoals.entity.SavesGoal;
import com.savesgoals.utils.PublicEnums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SavingPlanDTO {
    private Long id;
    private String userId;
    private PublicEnums.Currency currency;
    private BigDecimal currentMoney;
    private BigDecimal currentSaves;
    private Integer savesPercent;
    private List<SavesGoal> savesgoals;
}