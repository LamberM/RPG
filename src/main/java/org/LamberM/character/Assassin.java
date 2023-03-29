package org.LamberM.character;

import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;

public class Assassin extends Character {
    private final MenuChooser offensiveSkillsMenu;
    private final MenuChooser defensiveSkillsMenu;

    public Assassin(String name) {
        super(name, new Stats(15, 20, 10, 150, 40, 10, 60, 10, 1));
        offensiveSkillsMenu = new MenuChooser(new SystemInReader(), List.of("1.Hit in the back (20MP)", "2.Critical attack (30MP)", "3.Back to skill menu"));
        defensiveSkillsMenu = new MenuChooser(new SystemInReader(), List.of("1.Boost dodge and dexterity (20MP)", "2.Back to skill menu"));
    }

    @Override
    public int defensiveSkillsMenu() {
        if (myHeroCanUseSkill()) {
            int userChoice = defensiveSkillsMenu.userPick();
            switch (userChoice) {
                case 1 -> {
                    boostDodgeAndDexterity();
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

    @Override
    public int offensiveSkillsMenu() {
        if (myHeroCanUseSkill()) {
            int userChoice = offensiveSkillsMenu.userPick();
            switch (userChoice) {
                case 1 -> hitInTheBack();
                case 2 -> criticalAttackSkill();
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

    //////////////////////////////////// Offensive skills //////////////////////////////////////////////////////////
    private boolean currentMpIsEnoughToUseCriticalAttack() {
        return getDuelStats().getDuelMP() >= 30;
    }

    private int criticalAttackSkill() {
        if (currentMpIsEnoughToUseCriticalAttack()) {
            int damage = (40 + (getDuelStats().getDexterity() / 5));
            return damage;
        } else {
            System.out.println("You don't have enough mana point");
            return 9999;
        }
    }

    private int hitInTheBack() {
        getDuelStats().setDuelMP(getDuelStats().getDuelMP() - 20);
        int damage = 30 + (getDuelStats().getDexterity() / 5);
        return damage;
    }

    //////////////////////////////////// Defensive skills //////////////////////////////////////////////////////////
    private void boostDodgeAndDexterity() {
        getDuelStats().setDexterity(getDuelStats().getDexterity() + 10);
        getDuelStats().setDodge(getDuelStats().getDodge() + 5);
        getDuelStats().setCriticalChance(getDuelStats().getCriticalChance() + 5);
        getDuelStats().setDuelMP(getDuelStats().getDuelMP() - 20);
        System.out.println("I'm feeling agile like ninja");
    }

}