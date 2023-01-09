package org.LamberM.classes;

import org.LamberM.enemy.Enemy;
import org.LamberM.game.Game;
import org.LamberM.stats.Stats;

import java.util.Scanner;

public class Warrior extends Classes {
    public Warrior()
    {
        stats = new Stats(20, 15, 10, 200, 40, 5, 100, 5, 1);
        stats.setDuelStats();
    }
    private int userChoice;
    private boolean userPickIsBad()
    {
        return userChoice < 1 || userChoice > 4;
    }
    private boolean enemyAttackRangeIsMoreOrEqualsGameRange()
    {
        Game game = new Game();
        return duelStats.getAttackRange()>=game.range;
    }
    private void battleCry()
    {
        duelStats.setCurrentStr(duelStats.getCurrentStr() + 10);
        duelStats.setCurrentDex(duelStats.getCurrentDex() + 5);
        duelStats.setCurrentCritC(duelStats.getCurrentCritC() + 2);
        duelStats.setCurrentMP(duelStats.getCurrentMP() - 20);
        System.out.println("WAAAAAAAAAAAAAAAAAAAAAAAAAAARRRRRRRRRRR");
    }
    private void defensiveCry()
    {
        duelStats.setCurrentHP(duelStats.getCurrentHP() + 20);
        duelStats.setCurrentArm(duelStats.getCurrentArm() + 10);
        duelStats.setCurrentDodge(duelStats.getCurrentDodge() + 2);
        duelStats.setCurrentMP(duelStats.getCurrentMP() - 20);
        System.out.println("BAAAAAAAAAAAAAAAAAAAAAAAACCCCCKKKKKKKKKKKKKK");
    }
    private void doubleAttack()
    {
        Enemy enemy = new Enemy();
        if (enemyAttackRangeIsMoreOrEqualsGameRange())
        {
            if (heroAttackChanceIsMoreThanEnemyDodgeChance())
            {
                damage = 60 + (duelStats.getCurrentStr() / 5) - (enemy.enemyDuelStats.getCurrentArm() / 20);
                if (attackIsNotCritical())
                {
                    System.out.println("Attack for " + damage);
                    duelStats.setCurrentMP(duelStats.getCurrentMP() - 20);
                }
                else
                {
                    damage = 2 * damage;
                    System.out.println("Critical attack !!!! for " + damage + "!!!!");
                    duelStats.setCurrentMP(duelStats.getCurrentMP() - 20);
                }
                enemy.enemyDuelStats.setCurrentHP(enemy.enemyDuelStats.getCurrentHP() - damage); // nie działa
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
        chanceForAttackOrCriticalAttack();

        System.out.println("1.Battle cry (20MP)");
        System.out.println("2.Defensive cry (20MP)");
        System.out.println("3.Double attack (20MP)");
        System.out.println("4.Back to menu");
        userPick();
    }
}
