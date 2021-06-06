package com.financeservice.apiadminfinance.dtos;

import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.utils.PublicEnums;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CashFlowDto {
    private Long id;
    private PublicEnums.Color color;
    private BigDecimal amount;
    private String cashFlowName;
    private Boolean recurrent;
    private Category category;
}
