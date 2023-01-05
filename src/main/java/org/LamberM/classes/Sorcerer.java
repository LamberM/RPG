package org.LamberM.classes;


import org.LamberM.enemy.Enemy;
import org.LamberM.game.Game;
import org.LamberM.stats.HeroStats;
import org.LamberM.stats.Stats;

import java.util.Random;
import java.util.Scanner;

public class Sorcerer extends Classes {
    public Sorcerer()
    {
        Stats stats = new Stats(5, 15, 25, 120, 80, 5, 40, 5, 2);
    }
    HeroStats heroStats = new HeroStats();
    private int userChoice;
    private boolean userPickWillBeGood()
    {
        return userChoice <= 0 || userChoice >= 5;
    }
    private boolean enemyAttackRangeIsMoreOrEqualsGameRange()
    {
        Game game = new Game();
        return heroStats.getAttackRange()<=game.range;
    }
    private void fireBall()
    {
        Enemy enemy = new Enemy();
        if (enemyAttackRangeIsMoreOrEqualsGameRange())
        {
            if (heroAttackChanceIsMoreThanEnemyDodgeChance())
            {
                damage = 30 + (heroStats.getCurrentInt() / 5) - (enemy.enemyDuelStats.getCurrentArm() / 20);
                if (attackIsNotCritical())
                {
                    enemy.enemyDuelStats.setCurrentHP(enemy.enemyDuelStats.getCurrentHP() - damage);
                    System.out.println("Attack for " + damage);
                    heroStats.setCurrentMP(heroStats.getCurrentMP() - 25);
                }
                else
                {
                    damage = 2 * damage;
                    enemy.enemyDuelStats.setCurrentHP(enemy.enemyDuelStats.getCurrentHP() - damage);
                    System.out.println("Critical attack !!!! for " + damage + "!!!!");
                    heroStats.setCurrentMP(heroStats.getCurrentMP() - 25);
                }
            }
            else
            {
                System.out.println("You missed");
            }

        }
        else
        {
            System.out.println("Your attack range is too small");
        }
    }
    private boolean currentMpIsEnoughAndAttackRangeIsEnough()
    {
        Game game = new Game();
        return heroStats.getCurrentMP() >= 30 && heroStats.getAttackRange() <= game.range;
    }
    private boolean enemyWillBeFrozen()
    {
        Random draw = new Random();
        return draw.nextInt(9) == 1;
    }
    private void snowBall()
    {
        Enemy enemy = new Enemy();
        while (currentMpIsEnoughAndAttackRangeIsEnough())
        {
            if (heroAttackChanceIsMoreThanEnemyDodgeChance())
            {
                damage = 35 + (heroStats.getCurrentInt() / 5) - (enemy.enemyDuelStats.getCurrentArm() / 20);
                if (attackIsNotCritical())
                {
                    enemy.enemyDuelStats.setCurrentHP(enemy.enemyDuelStats.getCurrentHP() - damage);
                    System.out.println("Attack for " + damage);
                }
                else
                {
                    damage = 2 * damage;
                    enemy.enemyDuelStats.setCurrentHP(enemy.enemyDuelStats.getCurrentHP() - damage);
                    System.out.println("Critical attack !!!! for " + damage + "!!!!");
                }
                enemy.enemyDuelStats.setCurrentHP(enemy.enemyDuelStats.getCurrentHP() - damage);
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
            System.out.println("You don't have enough mana point or your attack range is too small");
    }
    private void frostArmor()
    {
        heroStats.setCurrentArm(heroStats.getCurrentArm() + 10);
        heroStats.setCurrentMP(heroStats.getCurrentMP() - 20);
        System.out.println(heroStats.getCurrentArm());
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
        while (userPickWillBeGood())
        {
            System.out.println("You entered the wrong number. Try again");
            skillsMenu();
        }
        switch (userChoice)
        {
            case 1 -> {
                fireBall();
            }
            case 2 -> {
                snowBall();
            }
            case 3 -> {
                frostArmor();
            }
        }
    }
    @Override
    public void skillsMenu()
    {
        chanceForAttackOrCriticalAttack();

        System.out.println("1.Fire ball (20MP)");
        System.out.println("2.Snow ball (30MP)");
        System.out.println("3.Frost armor (20MP)");
        System.out.println("4.Back to menu");
        userPick();

    }

}
