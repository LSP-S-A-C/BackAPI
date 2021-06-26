package com.savesgoals.dto;
import lombok.*;
import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SavingSheetsDTO {
    private Long id;
    private String idSavingPlan;
    private Integer period;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String savingSheetsName;
    private Boolean active;
}