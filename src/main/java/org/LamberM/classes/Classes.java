package org.LamberM.classes;

import org.LamberM.enemy.Enemy;
import org.LamberM.stats.DuelStats;
import org.LamberM.stats.Stats;

import java.util.Random;
import java.util.Scanner;

public abstract class Classes{

    public Stats stats= new Stats(1,1,1,1,1,1,1,1,1);
    public DuelStats duelStats = new DuelStats();

    private int heroChance;
    private int enemyChance;
    private int critChance;
    private int userChoice;
    public int damage;

    public void showStats()
    {
        stats.showStats();
    }

    public void duelStats()
    {
        System.out.println("My hero");
        duelStats.duelStats();
    }
    public void lvlUP()
    {
        stats.addStats();
    }
    private boolean heroCurrentHpAndMpWillBeMoreThanMaxHpAndMp()
    {
        return duelStats.getCurrentHP() > stats.getHp() || duelStats.getCurrentHP() > stats.getMp();
    }
    public void rest()
    {
        duelStats.setCurrentHP(duelStats.getCurrentHP() + 20);
        duelStats.setCurrentMP(duelStats.getCurrentMP() + 20);
        if (heroCurrentHpAndMpWillBeMoreThanMaxHpAndMp())
        {
            duelStats.setCurrentHP(stats.getHp());
            duelStats.setCurrentMP(stats.getMp());
        }
    }
    ///////////////////// functions use in Assassin, Sorcerer, Warrior ////////////////////////////
    void chanceForAttackOrCriticalAttack()
    {
        Random draw = new Random();
        Enemy enemy= new Enemy();
        heroChance= duelStats.getCurrentDex() + draw.nextInt(101);
        enemyChance=enemy.enemyDuelStats.getCurrentDodge() + draw.nextInt(101);
        critChance= duelStats.getCurrentCritC() + draw.nextInt(101);
    }
    boolean heroAttackChanceIsMoreThanEnemyDodgeChance()
    {
        return heroChance>enemyChance;
    }
    boolean attackIsNotCritical()
    {
        return critChance < 100;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean userPickIsBad()
    {
        return userChoice < 1 || userChoice > 2;
    }
    private void userPick()
    {
        Scanner scanner = new Scanner(System.in);
        userChoice = scanner.nextInt();
        if (userPickIsBad())
        {
            System.out.println("You entered the wrong number. Try again");
            attackMenu();
        }
        else
        {
            switch (userChoice)
            {
                case 1 -> attack();
                case 2 -> strongAttack();
            }
        }
    }
    private void attack(){
        Enemy enemy= new Enemy();
        System.out.println("My hero: ");

        chanceForAttackOrCriticalAttack();

        if (heroAttackChanceIsMoreThanEnemyDodgeChance())
        {
            damage = ((duelStats.getCurrentStr()+ (duelStats.getCurrentDex())) - (enemy.enemyDuelStats.getCurrentArm() / 20));

            if (attackIsNotCritical())
            {
                System.out.println("Attack for " + damage);
            }
            else
            {
                damage = 2 * damage;
                System.out.println("Critical attack !!!! for " + damage + "!!!!");
            }
            enemy.enemyDuelStats.setCurrentHP(enemy.enemyDuelStats.getCurrentHP() - damage);
        }
        else
        {
            System.out.println("You missed");
        }
    }
    private void strongAttack(){
        Enemy enemy= new Enemy();
        System.out.println("My hero: ");

        chanceForAttackOrCriticalAttack();

        if (heroAttackChanceIsMoreThanEnemyDodgeChance())
        {
            damage = 2*((duelStats.getCurrentStr()+ (duelStats.getCurrentDex())) - (enemy.enemyDuelStats.getCurrentArm() / 20));
            if (attackIsNotCritical())
            {
                System.out.println("Critical attack !!!! for " + damage + "!!!!");
                System.out.println("Attack for " + damage);
            }
            else
            {
                damage = 2 * damage;
                System.out.println("Critical attack !!!! for " + damage + "!!!!");
            }
            enemy.enemyDuelStats.setCurrentHP(enemy.enemyDuelStats.getCurrentHP() - damage);
        }
        else
        {
            System.out.println("You missed");
        }
    }
    public void attackMenu()
    {
        System.out.println("1.Attack");
        System.out.println("2.Strong Attack");
        userPick();
    }
    public void skillsMenu(){}

}
