package org.LamberM.classes;

import org.LamberM.enemy.Enemy;
import org.LamberM.game.Game;
import stats.Stats;

import java.util.Scanner;

public class Assassin extends Classes {
    public Assassin()
    {
        Stats stats = new Stats(15, 20, 10, 150, 40, 10, 60, 10, 1);
    }
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
    private void hitInTheBack()
    {
        Enemy enemy = new Enemy();
        if (enemyAttackRangeIsMoreOrEqualsGameRange() )
        {
            if (heroAttackChanceIsMoreThanEnemyDodgeChance())
            {
                damage = 30 + (heroStats.getCurrentDex() / 5) - (enemy.enemyDuelStats.getCurrentArm() / 20);
                if (attackIsNotCritical())
                {
                    System.out.println("Attack for " + damage);
                    heroStats.setCurrentMP(heroStats.getCurrentMP() - 20);
                }
                else
                {
                    damage = 2 * damage;
                    System.out.println("Critical attack !!!! for " + damage + "!!!!");
                    heroStats.setCurrentMP(heroStats.getCurrentHP() - 20);
                }
                enemy.enemyDuelStats.setCurrentHP(enemy.enemyDuelStats.getCurrentHP() - damage);

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
    private void boostDodgeAndDexterity()
    {
        heroStats.setCurrentDex(heroStats.getCurrentDex() + 10);
        heroStats.setCurrentDodge(heroStats.getCurrentDodge() + 5);
        heroStats.setCurrentCritC(heroStats.getCurrentCritC()+5);
        heroStats.setCurrentMP(heroStats.getCurrentMP() - 20);
        System.out.println("I'm feeling agile like ninja");
    }
    private boolean currentMpIsEnoughAndAttackRangeIsEnough()
    {
        Game game = new Game();
        return heroStats.getCurrentMP() >= 30 && heroStats.getAttackRange() <= game.range;
    }
    private void criticalAttack()
    {
        Enemy enemy = new Enemy();
        if (currentMpIsEnoughAndAttackRangeIsEnough())
        {
            if (heroAttackChanceIsMoreThanEnemyDodgeChance())
            {
                damage = 40 + (heroStats.getCurrentDex() / 5) - (enemy.enemyDuelStats.getCurrentArm() / 20);
                System.out.println("Attack for " + damage);
                heroStats.setCurrentMP(heroStats.getCurrentMP() - 30);

                enemy.enemyDuelStats.setCurrentHP(enemy.enemyDuelStats.getCurrentHP() - damage);

            }
            else
            {
                System.out.println("You missed");
            }
        }
        else
        {
            System.out.println("You don't have enough mana point or your attack range is too small");
        }
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
                hitInTheBack();
            }
            case 2 -> {
                boostDodgeAndDexterity();
            }
            case 3 -> {
                criticalAttack();
            }
            case 4 -> {
                System.out.println("Back to menu");
            }
        }
    }
    @Override
    public void skillsMenu()
    {
        chanceForAttackOrCriticalAttack();

        System.out.println("1.Hit in the back (20MP)");
        System.out.println("2.Boost dodge and dexterity (20MP)");
        System.out.println("3.Critical attack (30MP)");
        System.out.println("4.Back to menu");
        userPick();
    }

}