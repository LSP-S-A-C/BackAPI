package com.financeservice.apiadminfinance.util;
import com.financeservice.apiadminfinance.entity.CashFlow;
import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.utils.PublicEnums;
import java.math.BigDecimal;
public class CashFlowServiceDataTestUtils {

    static public CashFlow getValidCashFlow() {
        CashFlow cashflow = new CashFlow();
        cashflow.setCashFlowName("Sueldo Mensual");
        cashflow.setAmount(BigDecimal.valueOf(1000));
        cashflow.setCategory(new Category());
        cashflow.setColor(PublicEnums.Color.Blue);
        cashflow.setRecurrent(true);

        return cashflow;
    }

}
