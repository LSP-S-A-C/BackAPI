package com.financeservice.apiadminfinance.dtos;

import com.financeservice.apiadminfinance.entity.Category;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SavingSheetsDto {

    private Long id;
    private String idSavingPlan;
    private Integer period;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String savingSheetsName;
    private Boolean active;
    private List<Category> categories;

}
