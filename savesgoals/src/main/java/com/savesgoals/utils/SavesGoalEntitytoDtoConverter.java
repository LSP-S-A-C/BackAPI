package com.savesgoals.utils;
import java.util.List;
import java.util.stream.Collectors;
import com.savesgoals.dto.SavesGoalsDTO;
import com.savesgoals.entity.SavesGoal;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SavesGoalEntitytoDtoConverter {
    @Autowired
    private ModelMapper modelMapper;
    public SavesGoalsDTO convertEntityToDto(SavesGoal savesGoal) {
        return modelMapper.map(savesGoal, SavesGoalsDTO.class);
    }
    public List<SavesGoalsDTO> convertEntityToDto(List<SavesGoal> savesGoals) {
        return savesGoals.stream()
                .map(savesGoal -> convertEntityToDto(savesGoal))
                .collect(Collectors.toList());
    }
}
