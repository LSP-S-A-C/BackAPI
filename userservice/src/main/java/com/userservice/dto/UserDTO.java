package com.userservice.dto;
import com.userservice.utils.PublicEnums;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private PublicEnums.EmploymentStatus employmentStatus;
    private List<SavingPlanDTO> savingPlans;
}
