package com.savesgoals.dto;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SavesGoalsDTO {
    private Long id;
    private BigDecimal amountGoal;
    private String pathImage;
    private String description;
    private SavingPlanDTO savingplan;
}
