package com.financeservice.apiadminfinance.dtos;

import com.financeservice.apiadminfinance.entity.CashFlow;
import com.financeservice.apiadminfinance.entity.SavingSheets;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String categoryName;
    private Integer priority;
    private SavingSheets savingSheets;
    private List<CashFlow> cashFlows;
}
