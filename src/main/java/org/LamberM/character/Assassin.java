package org.LamberM.character;

import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;

public class Assassin extends Character {
    public Assassin()
    {
        super(new Stats(15, 20, 10, 150, 40, 10, 60, 10, 1));
    }

    MenuChooser offensiveSkillsMenu = new MenuChooser(new SystemInReader(),
            List.of(
                    "1.Hit in the back (20MP)",
                    "2.Critical attack (30MP)",
                    "3.Back to skill menu"
            )
    );
    MenuChooser defensiveSkillsMenu = new MenuChooser(new SystemInReader(),
            List.of(
                    "1.Boost dodge and dexterity (20MP)",
                    "2.Back to skill menu"
            )
    );

    //////////////////////////////////// Offensive skills //////////////////////////////////////////////////////////
    private boolean currentMpIsEnoughToUseCriticalAttack()
    {
        return duelStats.getDuelMP() >= 30;
    }
    private int criticalAttackSkill()
    {
        if (canUseAttackSkill()) {
            if (currentMpIsEnoughToUseCriticalAttack()) {
                int damage = (40 + (duelStats.getDexterity() / 5));
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
    private int hitInTheBack()
    {
        if (canUseAttackSkill()) {
            duelStats.setDuelMP(duelStats.getDuelMP() - 40);
            int damage = 30 + (duelStats.getDexterity() / 5);
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
            case 1 -> hitInTheBack();
            case 2 -> criticalAttackSkill();
            case 3 ->
            {
                System.out.println("Back to menu");
                return 9999;
            }
        }
        return 0;
    }
    //////////////////////////////////// Defensive skills //////////////////////////////////////////////////////////
    private void boostDodgeAndDexterity()
    {
        duelStats.setDexterity(duelStats.getDexterity() + 10);
        duelStats.setDodge(duelStats.getDodge() + 5);
        duelStats.setCriticalChance(duelStats.getCriticalChance()+5);
        duelStats.setDuelMP(duelStats.getDuelMP() - 20);
        System.out.println("I'm feeling agile like ninja");
    }

    @Override
    public int defensiveSkillsMenu()
    {
        int userChoice = defensiveSkillsMenu.userPick();
        switch (userChoice)
        {
            case 1 -> {
                boostDodgeAndDexterity();
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