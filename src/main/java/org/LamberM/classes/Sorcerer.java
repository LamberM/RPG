package org.LamberM.classes;


import lombok.Getter;
import lombok.Setter;
import org.LamberM.enemy.Enemy;
import org.LamberM.game.Game;
import org.LamberM.stats.DuelStats;
import org.LamberM.stats.Stats;

import java.util.Scanner;

public class Sorcerer extends Classes {
    public Sorcerer()
    {
        stats = new Stats(5, 15, 25, 120, 80, 5, 40, 5, 2);
        stats.setDuelStats();
    }
    DuelStats duelStats = new DuelStats();
    @Getter
    @Setter
    private int userChoice;
    private boolean userPickIsBad()
    {
        return userChoice < 1 || userChoice > 4;
    }
    private boolean enemyAttackRangeIsMoreOrEqualsGameRange()
    {
        Game game = new Game();
        return duelStats.getAttackRange()>=game.getRange();
    }
    private void fireBall()
    {
        Enemy enemy = new Enemy();
        if (enemyAttackRangeIsMoreOrEqualsGameRange())
        {
            if (heroAttackChanceIsMoreThanEnemyDodgeChance())
            {
                damage = 30 + (duelStats.getCurrentInt() / 5) - (enemy.enemyDuelStats.getCurrentArm() / 20);
                if (attackIsNotCritical())
                {
                    enemy.enemyDuelStats.setCurrentHP(enemy.enemyDuelStats.getCurrentHP() - damage);
                    System.out.println("Attack for " + damage);
                    duelStats.setCurrentMP(duelStats.getCurrentMP() - 25);
                }
                else
                {
                    damage = 2 * damage;
                    enemy.enemyDuelStats.setCurrentHP(enemy.enemyDuelStats.getCurrentHP() - damage);
                    System.out.println("Critical attack !!!! for " + damage + "!!!!");
                    duelStats.setCurrentMP(duelStats.getCurrentMP() - 25);
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
        return duelStats.getCurrentMP() >= 30 && duelStats.getAttackRange() >= game.getRange();
    }
//    private boolean enemyWillBeFrozen()
//    {
//        Random draw = new Random();
//        return draw.nextInt(9) == 1;
//    }
    private void snowBall()
    {
        Enemy enemy = new Enemy();
        if (currentMpIsEnoughAndAttackRangeIsEnough())
        {
            if (heroAttackChanceIsMoreThanEnemyDodgeChance())
            {
                damage = 35 + (duelStats.getCurrentInt() / 5) - (enemy.enemyDuelStats.getCurrentArm() / 20);
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
        else
        {
            System.out.println("You don't have enough mana point or your attack range is too small");
            userPick();
        }
    }
    private void frostArmor()
    {
        duelStats.setCurrentArm(duelStats.getCurrentArm() + 10);
        duelStats.setCurrentMP(duelStats.getCurrentMP() - 20);
        System.out.println(duelStats.getCurrentArm());
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
        chanceForAttackOrCriticalAttack();

        System.out.println("1.Fire ball (20MP)");
        System.out.println("2.Snow ball (30MP)");
        System.out.println("3.Frost armor (20MP)");
        System.out.println("4.Back to menu");
        userPick();

    }

}
