package com.savesgoals.converters;

import com.savesgoals.dto.SavesGoalsDTO;
import com.savesgoals.entity.SavesGoal;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SavesGoalsConverter extends AbstractConverter<SavesGoal, SavesGoalsDTO> {
    @Autowired
    private SavingsPlanConverter savingsPlanConverter;
    public SavesGoalsDTO fromEntity(SavesGoal entity) {
        if (entity == null) return null;
        return SavesGoalsDTO.builder()
        .id(entity.getId())
        .amountGoal(entity.getAmountGoal())
        .pathImage(entity.getPathImage())
        .description(entity.getDescription())
        .savingplan(savingsPlanConverter.fromEntity(entity.getSavingplan()))
        .build();
    }
    
    public SavesGoal fromDTO(SavesGoalsDTO dto) {
        if (dto == null) return null;
        return SavesGoal.builder()
        .id(dto.getId())
        .amountGoal(dto.getAmountGoal())
        .pathImage(dto.getPathImage())
        .description(dto.getDescription())
        .savingplan( savingsPlanConverter.fromDTO(dto.getSavingplan()))
        .build();
    }
}
