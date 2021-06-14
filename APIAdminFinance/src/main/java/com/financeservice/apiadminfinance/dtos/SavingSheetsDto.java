package com.financeservice.apiadminfinance.dtos;

import com.financeservice.apiadminfinance.entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Esta clase representa la hoja de ahorros")
public class SavingSheetsDto {

    private Long id;

    @ApiModelProperty(notes = "id del saving plan que crea la hoja de ahorros")
    private String idSavingPlan;

    @ApiModelProperty(notes = "Periodo de tiempo para hacer los pagos de la hoja de ahorros", example = "30")
    private Integer period;

    @ApiModelProperty(notes = "Fecha de inicio de la hoja de ahorro", example = "2021-06-12T19:02:16.985Z")
    private LocalDateTime startDate;

    @ApiModelProperty(notes = "Fecha de fin de la hoja de ahorro", example = "2021-07-12T19:02:16.985Z")
    private LocalDateTime endDate;

    @ApiModelProperty(notes = "Nombre de la hoja de ahorros", example = "Decoracion de cocina")
    private String savingSheetsName;

    @ApiModelProperty(notes = "Para saber si esta activa la hoja de ahorros")
    private Boolean active;

    @ApiModelProperty(notes = "Lista de categorias que tendra la hoja de ahorros")
    private List<Category> categories;

}
