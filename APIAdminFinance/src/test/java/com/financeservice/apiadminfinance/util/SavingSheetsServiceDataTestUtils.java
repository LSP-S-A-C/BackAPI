package com.financeservice.apiadminfinance.util;

import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.entity.SavingSheets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class SavingSheetsServiceDataTestUtils {

    static public SavingSheets getValidSavingSheets() {
        SavingSheets savingSheets = new SavingSheets();
        List<Category> category = new ArrayList<Category>();
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
