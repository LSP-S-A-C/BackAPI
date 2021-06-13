package com.userservice.dto;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(description = "Clase que representa una meta de ahorro")
public class SavesGoalsDTO {
    private Long id;
    @ApiModelProperty(notes = "Total de dinero que debe ahorrar para comprar lo que desea y cumplir su meta")
    private BigDecimal amountGoal;
    @ApiModelProperty(notes = "Imagen de lo que hizo que el usuario quiera ahorrar para comprarlo")
    private String pathImage;
    @ApiModelProperty(notes = "Descripción o comentario sobre el objetivo que se planteo el usuario")
    private String description;
    @ApiModelProperty(notes = "Plan de ahorro al que esta relacionado esta meta de ahorro")
    private SavingPlanDTO savingplan;
}
