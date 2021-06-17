package com.financeservice.apiadminfinance.dtos;
import com.financeservice.apiadminfinance.entity.CashFlow;
import com.financeservice.apiadminfinance.entity.SavingSheets;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Esta clase representa las categorias que tendra la hoja de ahorros")
public class CategoryDto {
    private Long id;

    @ApiModelProperty(notes = "Nombre de la categoria", example = "Juegos")
    private String categoryName;

    @ApiModelProperty(notes = "Prioridad de la categoria", example = "1")
    private Integer priority;

    @ApiModelProperty(notes = "Hoja de ahorros a la que la categoria esta relacionada")
    private SavingSheets savingSheets;

    @ApiModelProperty(notes = "Lista del flujo de efectivo de la categoria")
    private List<CashFlow> cashFlows;
}
