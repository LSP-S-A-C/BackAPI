package com.savesgoals.util;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.savesgoals.entity.SavesGoal;
import com.savesgoals.entity.SavingPlan;
import com.savesgoals.utils.PublicEnums.Currency;
public class SavingPlanServiceDataTestUtils {
    static public SavingPlan getValidCrateSavingPlan() {
        SavingPlan savingPlanDTO = new SavingPlan();
        BigDecimal cm = new BigDecimal(200);
        BigDecimal cs = new BigDecimal(40);
/*
        SavesGoalsDTO s1 = new SavesGoalsDTO();
        s1.setAmountGoal(new BigDecimal(400));
        s1.setDescription("hhh");
        s1.setPathImage("img");
        s1.setSavingplan(savingPlanDTO);
*/
        List<SavesGoal> savesGoal = new ArrayList<SavesGoal>();
        //savesGoal.add(s1);
        savingPlanDTO.setCurrency(Currency.PEN);
        savingPlanDTO.setCurrentMoney(cm);
        savingPlanDTO.setCurrentSaves(cs);
        savingPlanDTO.setUserId("1");
        savingPlanDTO.setSavesgoals(savesGoal);
        return savingPlanDTO;
    }


    static public SavesGoal getValidCrateSaveGoal() {
        SavesGoal savesGoalDTO = new SavesGoal();
        BigDecimal AG = new BigDecimal(800);
        savesGoalDTO.setAmountGoal(AG);
        savesGoalDTO.setDescription("Violin");
        savesGoalDTO.setPathImage("imagen_violin");
        SavingPlan savingPlanDTO = new SavingPlan();
        savesGoalDTO.setSavingplan(savingPlanDTO);
        return savesGoalDTO;
    }
}
