package com.savesgoals.controller;
import java.util.List;
import com.savesgoals.dto.SavesGoalsDTO;
import com.savesgoals.service.SavesGoalService;
import com.savesgoals.utils.SavesGoalDtotoEntityConverter;
import com.savesgoals.utils.SavesGoalEntitytoDtoConverter;
import com.savesgoals.utils.WrapperResponse;
import com.savesgoals.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/savesgoals")
public class SavesGoalsController {
    @Autowired
    private SavesGoalService savesGoalService;

    @Autowired
    private SavesGoalEntitytoDtoConverter converter1;

    @Autowired
    private SavesGoalDtotoEntityConverter converter2;

    @GetMapping
    public ResponseEntity<WrapperResponse<List<SavesGoalsDTO>>> findAll(
        @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber, 
        @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<SavesGoal> savesGoals = savesGoalService.list(page);
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(savesGoals)).createResponse();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<SavesGoalsDTO>> findById(@PathVariable(name="id") Long id){
        SavesGoal savesGoal = savesGoalService.listById(id).get();
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(savesGoal)).createResponse();
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<SavesGoalsDTO>> create(@RequestBody SavesGoalsDTO savesGoal){
        SavesGoal newSavesGoal = savesGoalService.create(  converter2.convertDtotoEntity(savesGoal));
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(newSavesGoal)).createResponse();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
        savesGoalService.delete(id);
        return new WrapperResponse<>(true, "success", null).createResponse();
    }
}
