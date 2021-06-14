package com.financeservice.apiadminfinance.util;

import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.entity.SavingSheets;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class SavingSheetsServiceDataTestUtils {

    static public SavingSheets getValidSavingSheets() {
        SavingSheets savingSheets = new SavingSheets();
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
        savingSheets.setIdSavingPlan("1");
        savingSheets.setPeriod(30);
        LocalDateTime startDate = LocalDateTime.of(2021, 1, 12, 19, 2, 16);
        LocalDateTime endDate = LocalDateTime.of(2021, 2, 12, 19, 2, 16);
        savingSheets.setStartDate(startDate);
        savingSheets.setEndDate(endDate);
        savingSheets.setSavingSheetsName("Decoracion cuarto");
        savingSheets.setActive(true);
        savingSheets.setCategories(category);

        return savingSheets;
    }

}
