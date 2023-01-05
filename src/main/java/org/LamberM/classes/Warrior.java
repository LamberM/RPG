package org.LamberM.classes;

import org.LamberM.enemy.Enemy;
import org.LamberM.game.Game;
import org.LamberM.stats.Stats;

import java.util.Scanner;

public class Warrior extends Classes {
    public Warrior()
    {
        Stats stats = new Stats(20, 15, 10, 200, 40, 5, 100, 5, 1);
    }
    private int userChoice;
    private boolean userPickIsGood()
    {
        return userChoice > 0 & userChoice < 5;
    }
    private boolean enemyAttackRangeIsMoreOrEqualsGameRange()
    {
        Game game = new Game();
        return heroStats.getAttackRange()<=game.range;
    }
    private void battleCry()
    {
        heroStats.setCurrentStr(heroStats.getCurrentStr() + 10);
        heroStats.setCurrentDex(heroStats.getCurrentDex() + 5);
        heroStats.setCurrentCritC(heroStats.getCurrentCritC() + 2);
        heroStats.setCurrentMP(heroStats.getCurrentMP() - 20);
        System.out.println("WAAAAAAAAAAAAAAAAAAAAAAAAAAARRRRRRRRRRR");

    }
    private void defensiveCry()
    {
        heroStats.setCurrentHP(heroStats.getCurrentHP() + 20);
        heroStats.setCurrentArm(heroStats.getCurrentArm() + 10);
        heroStats.setCurrentDodge(heroStats.getCurrentDodge() + 2);
        heroStats.setCurrentMP(heroStats.getCurrentMP() - 20);
        System.out.println("BAAAAAAAAAAAAAAAAAAAAAAAACCCCCKKKKKKKKKKKKKK");
    }
    private void doubleAttack()
    {
        Enemy enemy = new Enemy();
        if (enemyAttackRangeIsMoreOrEqualsGameRange())
        {
            if (heroAttackChanceIsMoreThanEnemyDodgeChance())
            {
                damage = 60 + (heroStats.getCurrentStr() / 5) - (enemy.enemyDuelStats.getCurrentArm() / 20);
                if (attackIsNotCritical())
                {
                    System.out.println("Attack for " + damage);
                    heroStats.setCurrentMP(heroStats.getCurrentMP() - 20);
                }
                else
                {
                    damage = 2 * damage;
                    System.out.println("Critical attack !!!! for " + damage + "!!!!");
                    heroStats.setCurrentMP(heroStats.getCurrentMP() - 20);
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
        while (userPickIsGood())
        {
            System.out.println("You entered the wrong number. Try again");
            skillsMenu();
        }
        switch (userChoice)
        {
            case 1 -> {
                battleCry();
            }
            case 2 -> {
                defensiveCry();
            }
            case 3 -> {
                doubleAttack();
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
