package com.financeservice.apiadminfinance.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table (name="SAVING_SHEETS")
public class SavingSheets {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PERIOD")
    private Integer period;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "SAVING_SHEETS_NAME", nullable = false)
    private String savingSheetsName;

    @Column(name = "ACTIVE", nullable = false)
    private Boolean active;

    @OneToMany(mappedBy = "savingSheets",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Category> categories;

}
