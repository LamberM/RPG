package org.LamberM.character;

import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;

public class Warrior extends Character {
    public Warrior()
    {
        super(new Stats(20, 15, 10, 200, 40, 5, 100, 5, 1));
    }
    MenuChooser offensiveSkillsMenu = new MenuChooser(new SystemInReader(),
            List.of(
                    "1.Double attack (20MP)",
                    "2.Back to skill menu"
            )
    );
    MenuChooser defensiveSkillsMenu = new MenuChooser(new SystemInReader(),
            List.of(
                    "1.Battle cry (20MP)",
                    "2.Defensive cry (20MP)",
                    "2.Back to skill menu"
            )
    );
    //////////////////////////////////// Defensive skills //////////////////////////////////////////////////////////
    private void battleCry()
    {
        duelStats.setStrength(duelStats.getStrength() + 10);
        duelStats.setArmor(duelStats.getArmor() + 5);
        duelStats.setCriticalChance(duelStats.getCriticalChance() + 2);
        duelStats.setDuelMP((duelStats.getDuelMP() - 20));
        System.out.println("WAAAAAAAAAAAAAAAAAAAAAAAAAAARRRRRRRRRRR");
    }
    private void defensiveCry()
    {
        duelStats.setDuelHP(duelStats.getDuelHP() + 20);
        duelStats.setArmor(duelStats.getArmor() + 10);
        duelStats.setDodge(duelStats.getDodge() + 2);
        duelStats.setDuelMP((duelStats.getDuelMP() - 20));
        System.out.println("BAAAAAAAAAAAAAAAAAAAAAAAACCCCCKKKKKKKKKKKKKK");
    }
    @Override
    public int defensiveSkillsMenu()
    {
        int userChoice = defensiveSkillsMenu.userPick();
        switch (userChoice)
        {
            case 1 -> {
                battleCry();
                return 0;
            }
            case 2 -> {
                defensiveCry();
                return 0;
            }
            case 3 ->
            {
                System.out.println("Back to menu");
                return 9999;
            }
        }
        return 0;
    }
    //////////////////////////////////// Offensive skills //////////////////////////////////////////////////////////
    private int doubleAttack()
    {
        if (canUseAttackSkill()) {
            duelStats.setDuelMP((duelStats.getDuelMP() - 20));
            int damage = 60 + (duelStats.getStrength() / 5);
            return damage;
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
            case 1 -> doubleAttack();
            case 2 ->
            {
                System.out.println("Back to menu");
                return 9999;
            }
        }
        return 0;
    }

}
