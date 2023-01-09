package org.LamberM.stats;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DuelStats
{
    private int attackRange;
    private int currentHP;
    private int currentMP;
    private int currentArm;
    private int currentStr;
    private int currentInt;
    private int currentDex;
    private int currentCritC;
    private int currentDodge;
    public void duelStats()
    {
        System.out.println("HP: " + currentHP + " MP: " + currentMP);
    }

}