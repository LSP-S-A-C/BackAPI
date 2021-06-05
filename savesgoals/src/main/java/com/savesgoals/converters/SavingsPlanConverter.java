package com.savesgoals.converters;
import java.util.List;
import java.util.stream.Collectors;

import com.savesgoals.dto.SavingPlanDTO;
import com.savesgoals.entity.SavingPlan;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class SavingsPlanConverter {

    public SavingPlanDTO fromEntity(SavingPlan entity) {
        if (entity == null) return null;
        return SavingPlanDTO.builder()
        .id(entity.getId()) 
        .userId(entity.getUserId())
        .currency(entity.getCurrency())
        .currentMoney(entity.getCurrentMoney())
        .currentSaves(entity.getCurrentSaves())
        .savesPercent(entity.getSavesPercent())
        .savesgoals(entity.getSavesgoals())
        .build();
    }
    

    public SavingPlan fromDTO(SavingPlanDTO dto) {
        if (dto == null) return null;
        return SavingPlan.builder()
        .id(dto.getId())
        .userId(dto.getUserId())
        .currency(dto.getCurrency())
        .currentMoney(dto.getCurrentMoney())
        .currentSaves(dto.getCurrentSaves())
        .savesPercent(dto.getSavesPercent())
        .savesgoals(dto.getSavesgoals())
        .build();
    }

    public List<SavingPlanDTO> fromEntity(List<SavingPlan> entities) {
        return entities.stream()
                .map(e -> fromEntity(e))
                .collect(Collectors.toList());
    }

    public List<SavingPlan> fromDTO(List<SavingPlanDTO> dtos) {
        return dtos.stream()
                .map(d -> fromDTO(d))
                .collect(Collectors.toList());
    }
}
