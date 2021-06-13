package com.financeservice.apiadminfinance.dtos;

import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.utils.PublicEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Clase que representa el flujo de efectivo o gastos realizados")
public class CashFlowDto {
    private Long id;

    @ApiModelProperty(notes = "Color decorativo", example = "Red")
    private PublicEnums.Color color;

    @ApiModelProperty(notes = "Cantidad, precio de la compra", example = "100")
    private BigDecimal amount;

    @ApiModelProperty(notes = "Nombre del flujo de efectivo realizado", example = "Play Station 5")
    private String cashFlowName;

    @ApiModelProperty(notes = "Confirmar si el gasto es recurrente o no", example = "PEN")
    private Boolean recurrent;

    @ApiModelProperty(notes = "Categoria a la que esta relacionada el flujo de efectivo")
    private Category category;
}
