package com.financeservice.apiadminfinance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.financeservice.apiadminfinance.utils.PublicEnums;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="cashFlow")
public class CashFlow {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COLOR")
    @Enumerated(EnumType.STRING)
    private PublicEnums.Color color;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @Column(name = "NAME", nullable = false, length = 30)
    private String cashFlowName;

    @Column(name = "RECURRENT", nullable = false)
    private Boolean recurrent;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="category_id", updatable = false)
    private Category category;
}
