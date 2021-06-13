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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api
@RestController
@RequestMapping("/savingplan")
public class SavingPlanController {

    @Autowired
    private SavingPlanService savingPlanService;

    @Autowired
    private SavingPlanEntitytoDtoConverter converter1;

    @Autowired
    private SavingPlanDtotoEntityConverter converter2;

    @ApiOperation(value = "Lee todas los planes de ahorro existentes")
    @GetMapping
    public ResponseEntity<WrapperResponse<List<SavingPlanDTO>>> findAll(
        @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber, 
        @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<SavingPlan> savingsPlans = savingPlanService.list(page);
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(savingsPlans)).createResponse();
    }

    @ApiOperation(value = "Lee un unico plan de ahorro basado en su id")
    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<SavingPlanDTO>> findById(@PathVariable(name="id") Long id){
        SavingPlan savingsPlan = savingPlanService.listById(id).get();
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(savingsPlan)).createResponse();
    }

    @ApiOperation(value = "Crea un plan de ahorro")
    @PostMapping
    public ResponseEntity<WrapperResponse<SavingPlanDTO>> create(@RequestBody SavingPlanDTO savingsPlan){
        SavingPlan newSavingsPlan = savingPlanService.create(converter2.convertDtotoEntity(savingsPlan));
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(newSavingsPlan)).createResponse();
    }

    @ApiOperation(value = "Actualiza un plan de ahorro")
    @PutMapping
    public ResponseEntity<WrapperResponse<SavingPlanDTO>> update(@RequestBody SavingPlanDTO savingsPlan){
        SavingPlan newSavingsPlan = savingPlanService.update(converter2.convertDtotoEntity(savingsPlan));
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(newSavingsPlan)).createResponse();
    }

    @ApiOperation(value = "Elimina un plan de ahorrro basado en su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
        savingPlanService.delete(id);
        return new WrapperResponse<>(true, "success", null).createResponse();
    }

    @ApiOperation(value = "Lee una lista de planes de ahorro basado en el ID del usuario")
    @GetMapping("/user/{id}")
    public ResponseEntity<WrapperResponse<List<SavingPlanDTO>>> findByUserId(
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize,
            @PathVariable(name="id") String id){
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<SavingPlan> savingPlanList = savingPlanService.listByUserId(id, page);
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(savingPlanList)).createResponse();
    }
}
