package org.LamberM.classes;

import org.LamberM.enemy.Enemy;
import org.LamberM.stats.HeroStats;
import org.LamberM.stats.Stats;

import java.util.Random;
import java.util.Scanner;

public abstract class Classes{
    public Stats stats = new Stats(1,1,1,1,1,1,1,1,1);
    public HeroStats heroStats = new HeroStats();

    private int heroChance;
    private int enemyChance;
    private int critChance;
    private int userChoice;
    public int damage;
    public void showStats()
    {
        heroStats.showStats();
    }
    public void duelStats()
    {
        System.out.println("My hero");
        heroStats.duelStats();
    }
    public void lvlUP()
    {
        stats.addStats();
    }
    private boolean heroCurrentHpAndMpWillBeMoreThanMaxHpAndMp()
    {
        return heroStats.getCurrentHP() > stats.getHp() || heroStats.getCurrentHP() > stats.getMp();
    }
    public void rest()
    {
        heroStats.setCurrentHP(heroStats.getCurrentHP() + 20);
        heroStats.setCurrentMP(heroStats.getCurrentMP() + 20);
        if (heroCurrentHpAndMpWillBeMoreThanMaxHpAndMp())
        {
            heroStats.setCurrentHP(stats.getHp());
            heroStats.setCurrentMP(stats.getMp());
        }
    }
    void chanceForAttackOrCriticalAttack(){
        Random draw = new Random();
        Enemy enemy= new Enemy();
        heroChance=heroStats.getCurrentDex() + draw.nextInt(101);
        enemyChance=enemy.enemyDuelStats.getCurrentDodge() + draw.nextInt(101);
        critChance=heroStats.getCurrentCritC() + draw.nextInt(101);
    }
    boolean heroAttackChanceIsMoreThanEnemyDodgeChance()
    {
        return heroChance>enemyChance;
    }
    boolean attackIsNotCritical()
    {
        return critChance < 100;
    }
    private boolean userPickWillBeGood(){
        return userChoice <= 0 || userChoice <=3;
    }
    private void userPick()
    {
        Scanner scanner = new Scanner(System.in);
        userChoice = scanner.nextInt();
        while (userPickWillBeGood()) {
            System.out.println("You entered the wrong number. Try again");
            attackMenu();
        }
        switch (userChoice) {
            case 1 -> {
                attack();
            }
            case 2 -> {
                strongAttack();
            }
        }
    }
    private void attack(){
        Enemy enemy= new Enemy();
        System.out.println("My hero: ");

        chanceForAttackOrCriticalAttack();

        if (heroAttackChanceIsMoreThanEnemyDodgeChance())
        {
            damage = ((heroStats.getCurrentStr()+ (heroStats.getCurrentDex())) - (enemy.enemyDuelStats.getCurrentArm() / 20));

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
        else {
            System.out.println("You missed");
        }
    }
    private void strongAttack(){
        Enemy enemy= new Enemy();
        System.out.println("My hero: ");

        chanceForAttackOrCriticalAttack();

        if (heroAttackChanceIsMoreThanEnemyDodgeChance()) {
            damage = 2*((heroStats.getCurrentStr()+ (heroStats.getCurrentDex())) - (enemy.enemyDuelStats.getCurrentArm() / 20));
            if (attackIsNotCritical()) {
                System.out.println("Critical attack !!!! for " + damage + "!!!!");
                System.out.println("Attack for " + damage);
            }
            else {
                damage = 2 * damage;
                System.out.println("Critical attack !!!! for " + damage + "!!!!");
            }
            enemy.enemyDuelStats.setCurrentHP(enemy.enemyDuelStats.getCurrentHP() - damage);
        }
        else {
            System.out.println("You missed");
        }
    }
    public void attackMenu() {
        System.out.println("1.Attack");
        System.out.println("2.Strong Attack");
        userPick();
    }
    public void skillsMenu(){}
}
