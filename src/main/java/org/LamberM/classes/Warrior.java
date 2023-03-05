package org.LamberM.classes;

import lombok.Getter;
import lombok.Setter;
import org.LamberM.enemy.Enemy;
import org.LamberM.stats.Stats;

import java.util.Scanner;

public class Warrior extends Classes {
    public Warrior()
    {
        stats = new Stats(20, 15, 10, 200, 40, 5, 100, 5, 1);
        duelStats = stats;
    }
    @Getter
    @Setter
    private int userChoice;
    private boolean userPickIsWrong()
    {
        return userChoice < 1 || userChoice > 4;
    }

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
    private void doubleAttack()
    {
        Enemy enemy = new Enemy();
        duelStats.setDuelMP((duelStats.getDuelMP() - 20));
            if (heroCanAttack())
            {
                duelStats.setDamage( 60 + (duelStats.getStrength() / 5) - (enemy.enemyDuelStats.getArmor() / 20));
                if (attackIsNotCritical())
                {
                    System.out.println("Attack for " + duelStats.getDamage());
                    enemy.enemyDuelStats.setDuelHP(enemy.enemyDuelStats.getDuelHP() - duelStats.getDamage());
                }
                else
                {
                    duelStats.setDamage( 2 * duelStats.getDamage());
                    System.out.println("Critical attack !!!! for " + duelStats.getDamage() + "!!!!");
                    enemy.enemyDuelStats.setDuelHP(enemy.enemyDuelStats.getDuelHP() - duelStats.getDamage());
                }
            }
            else
            {
                System.out.println("You missed");
            }

    }
    private void userPick()
    {
        Scanner scanner = new Scanner(System.in);
        userChoice = scanner.nextInt();
        if (userPickIsWrong())
        {
            System.out.println("You entered the wrong number. Try again");
            skillsMenu();
        }
        else
        {
            switch (userChoice)
            {
                case 1 -> battleCry();
                case 2 -> defensiveCry();
                case 3 -> doubleAttack();
                case 4 -> System.out.println("Back to menu");
            }
        }
    }
    @Override
    public void skillsMenu()
    {
        missOrBaseOrCritAttack();

        System.out.println("1.Battle cry (20MP)");
        System.out.println("2.Defensive cry (20MP)");
        System.out.println("3.Double attack (20MP)");
        System.out.println("4.Back to menu");
        userPick();
    }
}
