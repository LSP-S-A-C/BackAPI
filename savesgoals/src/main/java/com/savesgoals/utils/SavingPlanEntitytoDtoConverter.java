package com.savesgoals.utils;
import java.util.List;
import java.util.stream.Collectors;
import com.savesgoals.dto.SavingPlanDTO;
import com.savesgoals.entity.SavingPlan;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SavingPlanEntitytoDtoConverter {
    @Autowired
    private ModelMapper modelMapper;

    public SavingPlanDTO convertEntityToDto(SavingPlan savingPlan) {
        return modelMapper.map(savingPlan, SavingPlanDTO.class);
    }
    public List<SavingPlanDTO> convertEntityToDto(List<SavingPlan> savingPlans) {
        return savingPlans.stream()
                .map(savingPlan -> convertEntityToDto(savingPlan))
                .collect(Collectors.toList());
    }
}