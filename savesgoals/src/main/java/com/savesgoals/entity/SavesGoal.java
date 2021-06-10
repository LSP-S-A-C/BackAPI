package com.savesgoals.entity;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "SAVES_GOALS")
public class SavesGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "AMOUNT_GOAL")
    private BigDecimal amountGoal;

    @Column(name = "PATH_IMAGE")
    private String pathImage;

    @Column(name = "DESCRIPTION", length = 512)
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private SavingPlan savingplan;
}
/*
{
    "amountGoal": 800,
    "description": "piano barato",
    "pathImage": "ASD12ue93209ajsdlkasda",
    "savingplan": {
      "id": 1
    }
}
*/
