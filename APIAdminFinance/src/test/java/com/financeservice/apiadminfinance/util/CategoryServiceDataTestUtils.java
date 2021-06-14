package com.financeservice.apiadminfinance.util;

import com.financeservice.apiadminfinance.entity.CashFlow;
import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.entity.SavingSheets;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceDataTestUtils {

    static public Category getValidCategory() {
        Category category = new Category();
        List<CashFlow> cashflow = new ArrayList<CashFlow>();
        category.setCategoryName("Feeding");
        category.setPriority(2);
        category.setCashFlows(cashflow);
        category.setSavingSheets(new SavingSheets());

        return category;
    }

}
