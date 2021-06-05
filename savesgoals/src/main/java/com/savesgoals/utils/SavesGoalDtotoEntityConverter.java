package com.savesgoals.utils;
import java.util.List;
import java.util.stream.Collectors;
import com.savesgoals.dto.SavesGoalsDTO;
import com.savesgoals.entity.SavesGoal;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SavesGoalDtotoEntityConverter {
    @Autowired
    private ModelMapper modelMapper;
    public SavesGoal convertDtotoEntity(SavesGoalsDTO savesGoalsDTO) {
        return modelMapper.map(savesGoalsDTO, SavesGoal.class);
    }
    public List<SavesGoal> convertDtotoEntity(List<SavesGoalsDTO> savesGoalsDTOs) {
        return savesGoalsDTOs.stream()
                .map(savesGoalsDTO -> convertDtotoEntity(savesGoalsDTO))
                .collect(Collectors.toList());
    }
}
