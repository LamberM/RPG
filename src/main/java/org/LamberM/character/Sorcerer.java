package org.LamberM.character;


import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;

public class Sorcerer extends Character {
    private final MenuChooser offensiveSkillsMenu;
    private final MenuChooser defensiveSkillsMenu;

    public Sorcerer(String name) {
        super(name, new Stats(5, 15, 25, 120, 80, 5, 40, 5, 2));
        offensiveSkillsMenu = new MenuChooser(new SystemInReader(), List.of("1.Fire ball (20MP)", "2.Snow ball (30MP)", "3.Back to skill menu"));
        defensiveSkillsMenu = new MenuChooser(new SystemInReader(), List.of("1.Frost armor (20MP)", "2.Back to skill menu"));
    }

    @Override
    public int offensiveSkillsMenu() {
        if (myHeroCanUseSkill()) {
            int userChoice = offensiveSkillsMenu.userPick();
            switch (userChoice) {
                case 1 -> fireBall();
                case 2 -> snowBall();
                case 3 -> {
                    System.out.println("Back to menu");
                    return 9999;
                }
            }
            return 0;
        } else {
            System.out.println("You don't have enough mana points (20MP) ");
            System.out.println("Back to menu");
            return 9999;
        }
    }

    @Override
    public int defensiveSkillsMenu() {
        if (myHeroCanUseSkill()) {
            int userChoice = defensiveSkillsMenu.userPick();
            switch (userChoice) {
                case 1 -> {
                    frostArmor();
                    return 0;
                }
                case 2 -> {
                    System.out.println("Back to menu");
                    return 9999;
                }
            }
            return 0;
        } else {
            System.out.println("You don't have enough mana points (20MP) ");
            System.out.println("Back to menu");
            return 9999;
        }
    }

    //////////////////////////////////// Offensive skills //////////////////////////////////////////////////////////
    private int fireBall() {
        getDuelStats().setDuelMP(getDuelStats().getDuelMP() - 20);
        int damage = 30 + (getDuelStats().getIntelligence() / 5);
        return damage;
    }

    private boolean currentMpIsEnoughToUseSnowBall() {
        return getDuelStats().getDuelMP() >= 30;
    }

    private int snowBall() {
        if (currentMpIsEnoughToUseSnowBall()) {
            getDuelStats().setDuelMP(getDuelStats().getDuelMP() - 30);
            int damage = 45 + (getDuelStats().getIntelligence() / 5);
            return damage;
        } else {
            System.out.println("You don't have enough mana point");
            return 9999;
        }
    }

    //////////////////////////////////// Defensive skills //////////////////////////////////////////////////////////
    private void frostArmor() {
        getDuelStats().setArmor(getDuelStats().getArmor() + 10);
        getDuelStats().setDuelMP((getDuelStats().getDuelMP() - 20));
        System.out.println("I feel freeze");
    }

}
