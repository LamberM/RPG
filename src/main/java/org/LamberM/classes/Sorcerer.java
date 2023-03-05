package org.LamberM.classes;


import lombok.Getter;
import lombok.Setter;
import org.LamberM.enemy.Enemy;
import org.LamberM.stats.Stats;

import java.util.Scanner;

public class Sorcerer extends Classes {
    public Sorcerer()
    {
        stats = new Stats(5, 15, 25, 120, 80, 5, 40, 5, 2);
        duelStats = stats;
    }

    @Getter
    @Setter
    private int userChoice;
    private boolean userPickIsBad()
    {
        return userChoice < 1 || userChoice > 4;
    }

    private void fireBall()
    {
        Enemy enemy = new Enemy();
        duelStats.setDuelMP(duelStats.getDuelMP() - 20);
            if (heroCanAttack())
            {
                duelStats.setDamage(30 + (duelStats.getIntelligence() / 5) - (enemy.enemyDuelStats.getArmor() / 20));
                if (attackIsNotCritical())
                {
                    enemy.enemyDuelStats.setDuelHP(enemy.enemyDuelStats.getDuelHP() - duelStats.getDamage());
                    System.out.println("Attack for " + duelStats.getDamage());
                }
                else
                {
                    duelStats.setDamage(2 * duelStats.getDamage());
                    enemy.enemyDuelStats.setDuelHP(enemy.enemyDuelStats.getDuelHP() - duelStats.getDamage());
                    System.out.println("Critical attack !!!! for " + duelStats.getDamage() + "!!!!");
                }
            }
            else
            {
                System.out.println("You missed");
            }

    }
    private boolean currentMpIsEnoughToUseSnowBall()
    {
        return duelStats.getDuelMP() >= 30;
    }
//    private boolean enemyWillBeFrozen()
//    {
//        Random draw = new Random();
//        return draw.nextInt(9) == 1;
//    }
    private void snowBall()
    {
        Enemy enemy = new Enemy();
        if (currentMpIsEnoughToUseSnowBall())
        {
            duelStats.setDuelMP(duelStats.getDuelMP() - 30);
            if (heroCanAttack())
            {
                duelStats.setDamage( 35 + (duelStats.getIntelligence() / 5) - (enemy.enemyDuelStats.getArmor() / 20));
                if (attackIsNotCritical())
                {
                    enemy.enemyDuelStats.setHp(enemy.enemyDuelStats.getHp() - duelStats.getDamage());
                    System.out.println("Attack for " + duelStats.getDamage());
                    enemy.enemyDuelStats.setDuelHP(enemy.enemyDuelStats.getDuelHP() - duelStats.getDamage());
                }
                else
                {
                    duelStats.setDamage( 2 * duelStats.getDamage());

                    System.out.println("Critical attack !!!! for " + duelStats.getDamage() + "!!!!");
                    enemy.enemyDuelStats.setDuelHP(enemy.enemyDuelStats.getDuelHP() - duelStats.getDamage());
                }
//                  if (enemyWillBeFrozen())
//                  {
//                      System.out.println("You froze enemy, he lost his turn");
//                  }
//                  do ogarnięcia
            }
            else
            {
                System.out.println("You missed");
            }
        }
        else
        {
            System.out.println("You don't have enough mana point");
            userPick();
        }
    }
    private void frostArmor()
    {
        duelStats.setArmor(duelStats.getArmor() + 10);
        duelStats.setDuelMP((duelStats.getDuelMP() - 20));
        System.out.println("I feel freeze");
//      if (enemyWillBeFrozen())
//      {
//        System.out.println("You froze enemy, he lost his turn");
//      }
//      do ogarnięcia
    }
    private void userPick()
    {
        Scanner scanner = new Scanner(System.in);
        userChoice = scanner.nextInt();
        if (userPickIsBad())
        {
            System.out.println("You entered the wrong number. Try again");
            skillsMenu();
        }
        else
        {
            switch (userChoice)
            {
                case 1 -> fireBall();
                case 2 -> snowBall();
                case 3 -> frostArmor();
                case 4 -> System.out.println("Back to menu");
            }
        }
    }
    @Override
    public void skillsMenu()
    {
        missOrBaseOrCritAttack();

        System.out.println("1.Fire ball (20MP)");
        System.out.println("2.Snow ball (30MP)");
        System.out.println("3.Frost armor (20MP)");
        System.out.println("4.Back to menu");
        userPick();

    }

}
