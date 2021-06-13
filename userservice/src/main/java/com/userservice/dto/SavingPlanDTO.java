package com.userservice.dto;
import java.math.BigDecimal;
import java.util.List;
import com.userservice.utils.PublicEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Esta clase representa un plan de ahorro")
public class SavingPlanDTO {
    private Long id;
    @ApiModelProperty(notes = "id del usuario que crea el plan de ahorro")
    private String userId;
    @ApiModelProperty(notes = "Tipo de moneda", example = "PEN")
    private PublicEnums.Currency currency;
    @ApiModelProperty(notes = "Dinero actual", example = "2000")
    private BigDecimal currentMoney;
    @ApiModelProperty(notes = "Ahorro actual", example = "900")
    private BigDecimal currentSaves;
    @ApiModelProperty(notes = "Porcentaje que ahorrar el usuario cada vez que obtenga un ingreso", example = "15")
    private Integer savesPercent;
    @ApiModelProperty(notes = "Lista de objetivos a ahorrar del usuario")
    private List<SavesGoalsDTO> savesgoals;
}