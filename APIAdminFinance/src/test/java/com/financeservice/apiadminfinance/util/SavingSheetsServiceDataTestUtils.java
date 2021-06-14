package com.financeservice.apiadminfinance.util;

import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.entity.SavingSheets;
import com.ibm.j9ddr.vm29.j9.DataType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SavingSheetsServiceDataTestUtils {

    static public SavingSheets getValidCrateSavingSheets() {
        SavingSheets savingSheetsDTO = new SavingSheets();
        BigDecimal cm = new BigDecimal(200);
        BigDecimal cs = new BigDecimal(40);

/*
        SavesGoalsDTO s1 = new SavesGoalsDTO();
        s1.setAmountGoal(new BigDecimal(400));
        s1.setDescription("hhh");
        s1.setPathImage("img");
        s1.setSavingplan(savingPlanDTO);
*/
        List<Category> category = new ArrayList<Category>();
        //savesGoal.add(s1);
        savingSheetsDTO.setIdSavingPlan("1");
        savingSheetsDTO.setPeriod(30);
        savingSheetsDTO.setStartDate(2021-06-12T19:02:16.985Z);
        savingSheetsDTO.setEndDate(2021-07-12T19:02:16.985Z);
        savingSheetsDTO.setSavingSheetsName("Decoracion cuarto");
        savingSheetsDTO.setActive(true);
        savingSheetsDTO.setCategories(category);

        return savingSheetsDTO;
    }


    static public SavesGoal getValidCrateSaveGoal() {
        SavesGoal savesGoalDTO = new SavesGoal();
        BigDecimal AG = new BigDecimal(800);
        savesGoalDTO.setAmountGoal(AG);
        savesGoalDTO.setDescription("Violin");
        savesGoalDTO.setPathImage("imagen_violin");
        SavingPlan savingPlanDTO = new SavingPlan();
        savesGoalDTO.setSavingplan(savingPlanDTO);
        return savesGoalDTO;
    }

}
