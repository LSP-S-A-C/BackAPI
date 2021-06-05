package com.savesgoals.utils;
import java.util.List;
import java.util.stream.Collectors;
import com.savesgoals.dto.SavingPlanDTO;
import com.savesgoals.entity.SavingPlan;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SavingPlanDtotoEntityConverter {
    @Autowired
    private ModelMapper modelMapper;
    public SavingPlan convertDtotoEntity(SavingPlanDTO savingPlanDTO) {
        return modelMapper.map(savingPlanDTO, SavingPlan.class);
    }
    public List<SavingPlan> convertDtotoEntity(List<SavingPlanDTO> savingPlanDTOs) {
        return savingPlanDTOs.stream()
                .map(savesGoalsDTO -> convertDtotoEntity(savesGoalsDTO))
                .collect(Collectors.toList());
    }
}
