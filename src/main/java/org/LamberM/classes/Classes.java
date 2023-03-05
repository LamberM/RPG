package org.LamberM.classes;

import lombok.Getter;
import lombok.Setter;
import org.LamberM.enemy.Enemy;
import org.LamberM.stats.Stats;

import java.util.Random;
import java.util.Scanner;
@Getter
public abstract class Classes{

    public Stats stats= new Stats(10,10,10,50,30,10,10,10,1);
    public Stats duelStats= stats;
    private int heroChance;
    private int enemyChance;
    private int critChance;
    @Setter
    private int userChoice;

    public void showStats()
    {
        stats.showStats();
    }

    public void statsInDuel()
    {
        System.out.println("My hero");
        duelStats.duelStats();
    }
    public void lvlUP()
    {
        stats.addStats();
    }
    private boolean currentHpIsMoreThanMax()
    {
        return duelStats.getDuelHP() > duelStats.getHp() || duelStats.getDuelMP() > duelStats.getMp();
    }
    public void rest()
    {
        duelStats.setDuelHP(duelStats.getDuelHP() + 20);
        duelStats.setDuelMP(duelStats.getDuelMP() + 20);
        if (currentHpIsMoreThanMax())
        {
            duelStats.setDuelHP(duelStats.getHp());
            duelStats.setDuelMP(duelStats.getMp());
        }
        else
        {
            System.out.println("Your HP: "+duelStats.getDuelHP());
            System.out.println("Your MP: "+duelStats.getDuelMP());
        }
    }
    ///////////////////// functions use in Assassin, Sorcerer, Warrior ////////////////////////////
    void missOrBaseOrCritAttack()
    {
        Random draw = new Random();
        Enemy enemy= new Enemy();
        heroChance= duelStats.getDexterity() + draw.nextInt(101);
        enemyChance=enemy.enemyDuelStats.getDodge() + draw.nextInt(101);
        critChance= duelStats.getCriticalChance() + draw.nextInt(101);
    }
    boolean heroCanAttack()
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

        missOrBaseOrCritAttack();

        if (heroCanAttack())
        {
            duelStats.setDamage((duelStats.getStrength()+ (duelStats.getDexterity())) - (enemy.enemyDuelStats.getArmor() / 20));

            if (attackIsNotCritical())
            {
                System.out.println("Attack for " + duelStats.getDamage());
                enemy.enemyDuelStats.setDuelHP(enemy.enemyDuelStats.getHp() - duelStats.getDamage());
            }
            else
            {
                duelStats.setDamage(2 * duelStats.getDamage());
                System.out.println("Critical attack !!!! for " + duelStats.getDamage());
                enemy.enemyDuelStats.setDuelHP(enemy.enemyDuelStats.getHp() - duelStats.getDamage());
            }
        }
        else
        {
            System.out.println("You missed");
        }
    }
    private void strongAttack(){
        Enemy enemy= new Enemy();
        System.out.println("My hero: ");

        missOrBaseOrCritAttack();

        if (heroCanAttack())
        {
            duelStats.setDamage(2*((duelStats.getStrength()+ (duelStats.getDexterity())) - (enemy.enemyDuelStats.getArmor() / 20)));
            if (attackIsNotCritical())
            {
                System.out.println("Attack for " + duelStats.getDamage());
                enemy.enemyDuelStats.setDuelHP(enemy.enemyDuelStats.getHp() - duelStats.getDamage());
            }
            else
            {
                duelStats.setDamage( 2 * duelStats.getDamage());
                System.out.println("Critical attack !!!! for " + duelStats.getDamage() + "!!!!");
                enemy.enemyDuelStats.setDuelHP(enemy.enemyDuelStats.getHp() - duelStats.getDamage());
            }
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
