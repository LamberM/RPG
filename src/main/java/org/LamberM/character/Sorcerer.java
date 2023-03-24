package org.LamberM.character;


import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;

public class Sorcerer extends Character {
    public Sorcerer()
    {
        super( new Stats(5, 15, 25, 120, 80, 5, 40, 5, 2));
    }
    MenuChooser offensiveSkillsMenu = new MenuChooser(new SystemInReader(),
            List.of(
                    "1.Fire ball (20MP)",
                    "2.Snow ball (30MP)",
                    "3.Back to skill menu"
            )
    );
    MenuChooser defensiveSkillsMenu = new MenuChooser(new SystemInReader(),
            List.of(
                    "1.Frost armor (20MP)",
                    "2.Back to skill menu"
            )
    );
    //////////////////////////////////// Offensive skills //////////////////////////////////////////////////////////
    private int fireBall()
    {
        if(canUseAttackSkill()) {
            duelStats.setDuelMP(duelStats.getDuelMP() - 20);
            int damage = 30 + (duelStats.getIntelligence() / 5);
            return damage;
        }
        else {
            System.out.println("You don't have enough attack range");
            return 9999;
        }
    }
    private boolean currentMpIsEnoughToUseSnowBall()
    {
        return duelStats.getDuelMP() >= 30;
    }

    private int snowBall() {
        if (canUseAttackSkill()) {
            if (currentMpIsEnoughToUseSnowBall()) {
                duelStats.setDuelMP(duelStats.getDuelMP() - 30);
                int damage = 45 + (duelStats.getIntelligence() / 5);
                return damage;
            } else {
                System.out.println("You don't have enough mana point");
                return 9999;
            }
        }
        else {
            System.out.println("You don't have enough attack range");
            return 9999;
        }
    }
    @Override
    public int offensiveSkillsMenu()
    {
        int userChoice = offensiveSkillsMenu.userPick();
        switch (userChoice)
        {
            case 1 -> fireBall();
            case 2 -> snowBall();
            case 3 ->
            {
                System.out.println("Back to menu");
                return 9999;
            }
        }
        return 0;
    }
    //////////////////////////////////// Defensive skills //////////////////////////////////////////////////////////
    private void frostArmor() {
        duelStats.setArmor(duelStats.getArmor() + 10);
        duelStats.setDuelMP((duelStats.getDuelMP() - 20));
        System.out.println("I feel freeze");
    }

    @Override
    public int defensiveSkillsMenu()
    {
        int userChoice = defensiveSkillsMenu.userPick();
        switch (userChoice)
        {
            case 1 -> {
                frostArmor();
                return 0;
            }
            case 2 ->
            {
                System.out.println("Back to menu");
                return 9999;
            }
        }
        return 0;
    }
}
