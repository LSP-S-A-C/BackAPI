package com.savesgoals.controller;
import java.util.List;
import com.savesgoals.dto.SavingPlanDTO;
import com.savesgoals.entity.SavingPlan;
import com.savesgoals.service.SavingPlanService;
import com.savesgoals.utils.SavingPlanDtotoEntityConverter;
import com.savesgoals.utils.SavingPlanEntitytoDtoConverter;
import com.savesgoals.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/savingplan")
public class SavingPlanController {

    @Autowired
    private SavingPlanService savingPlanService;

    @Autowired
    private SavingPlanEntitytoDtoConverter converter1;

    @Autowired
    private SavingPlanDtotoEntityConverter converter2;

    @GetMapping
    public ResponseEntity<WrapperResponse<List<SavingPlanDTO>>> findAll(
        @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber, 
        @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<SavingPlan> savingsPlans = savingPlanService.list(page);
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(savingsPlans)).createResponse();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<SavingPlanDTO>> findById(@PathVariable(name="id") Long id){
        SavingPlan savingsPlan = savingPlanService.listById(id).get();
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(savingsPlan)).createResponse();
    }



    @PostMapping
    public ResponseEntity<WrapperResponse<SavingPlanDTO>> create(@RequestBody SavingPlanDTO savingsPlan){
        SavingPlan newSavingsPlan = savingPlanService.create(converter2.convertDtotoEntity(savingsPlan));
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(newSavingsPlan)).createResponse();
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<SavingPlanDTO>> update(@RequestBody SavingPlanDTO savingsPlan){
        SavingPlan newSavingsPlan = savingPlanService.update(converter2.convertDtotoEntity(savingsPlan));
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(newSavingsPlan)).createResponse();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
        savingPlanService.delete(id);
        return new WrapperResponse<>(true, "success", null).createResponse();
    }

    // encuentra savingplans por id de usuario
}
