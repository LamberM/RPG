package org.LamberM.character;

import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;

public class Warrior extends Character {
    private final MenuChooser offensiveSkillsMenu;
    private final MenuChooser defensiveSkillsMenu;

    public Warrior(String name) {
        super(name, new Stats(20, 15, 10, 200, 40, 5, 100, 5, 1));
        offensiveSkillsMenu = new MenuChooser(new SystemInReader(), List.of("1.Double attack (20MP)", "2.Back to skill menu"));
        defensiveSkillsMenu = new MenuChooser(new SystemInReader(), List.of("1.Battle cry (20MP)", "2.Defensive cry (20MP)", "2.Back to skill menu"));
    }

    @Override
    public int defensiveSkillsMenu() {
        if (myHeroCanUseSkill()) {
            int userChoice = defensiveSkillsMenu.userPick();
            switch (userChoice) {
                case 1 -> {
                    battleCry();
                    return 0;
                }
                case 2 -> {
                    defensiveCry();
                    return 0;
                }
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
    public int offensiveSkillsMenu() {
        if (myHeroCanUseSkill()) {
            int userChoice = offensiveSkillsMenu.userPick();
            switch (userChoice) {
                case 1 -> doubleAttack();
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

    //////////////////////////////////// Defensive skills //////////////////////////////////////////////////////////
    private void battleCry() {
        getDuelStats().setStrength(getDuelStats().getStrength() + 10);
        getDuelStats().setArmor(getDuelStats().getArmor() + 5);
        getDuelStats().setCriticalChance(getDuelStats().getCriticalChance() + 2);
        getDuelStats().setDuelMP((getDuelStats().getDuelMP() - 20));
        System.out.println("WAAAAAAAAAAAAAAAAAAAAAAAAAAARRRRRRRRRRR");
    }

    private void defensiveCry() {
        getDuelStats().setDuelHP(getDuelStats().getDuelHP() + 20);
        getDuelStats().setArmor(getDuelStats().getArmor() + 10);
        getDuelStats().setDodge(getDuelStats().getDodge() + 2);
        getDuelStats().setDuelMP((getDuelStats().getDuelMP() - 20));
        System.out.println("BAAAAAAAAAAAAAAAAAAAAAAAACCCCCKKKKKKKKKKKKKK");
    }

    //////////////////////////////////// Offensive skills //////////////////////////////////////////////////////////
    private int doubleAttack() {
        getDuelStats().setDuelMP((getDuelStats().getDuelMP() - 20));
        int damage = 60 + (getDuelStats().getStrength() / 5);
        return damage;

    }
}
