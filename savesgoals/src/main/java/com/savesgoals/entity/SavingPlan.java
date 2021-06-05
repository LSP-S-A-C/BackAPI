package com.savesgoals.entity;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.savesgoals.utils.PublicEnums;
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
@Table(name = "SAVING_PLANS")
public class SavingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private String userId;
    
    @Column(name = "CURRENCY")
    @Enumerated(EnumType.STRING)
    private PublicEnums.Currency currency;
    
    @Column(name = "CURRENT_MONEY")
    private BigDecimal currentMoney;
    
    @Column(name = "CURRENT_SAVES")
    private BigDecimal currentSaves;
    
    @Column(name = "SAVES_PERCENT")
    private Integer savesPercent;
    
    @OneToMany(mappedBy = "savingplan")
    private List<SavesGoal> savesgoals;
}
