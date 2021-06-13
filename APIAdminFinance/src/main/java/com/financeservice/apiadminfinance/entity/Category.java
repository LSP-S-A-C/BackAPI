package com.financeservice.apiadminfinance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table (name="CATEGORY")
public class Category {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CATEGORY", nullable = false, length = 30)
    private String categoryName;

    @Column(name = "PRIORITY")
    private Integer priority;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="savingSheets_id", updatable = false)
    private SavingSheets savingSheets;


    @OneToMany(mappedBy = "category",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CashFlow> cashFlows;
}
