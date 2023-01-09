package org.LamberM.stats;

import org.LamberM.game.Game;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;
@Getter
@Setter
public class Stats
{
    //////////////////// all about lvling, exping, adding stats ////////////////////////////////
    private int exp = 0;
    private int lvl = 1;
    private int lvl_to_compare = 2;
    private int currentPoints;
    private int userChoice;
    /////////////////////////// General Stats //////////////////////////////////////////////////
    private int hp;
    private int mp;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int armor;
    private int dodge;
    private int criticalChance;
    private int attackRange;

    public Stats(int strength, int dexterity, int intelligence, int hp, int mp, int dodge, int armor, int criticalChance, int attackRange)
    {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.hp = hp;
        this.mp = mp;
        this.dodge = dodge;
        this.armor = armor;
        this.criticalChance = criticalChance;
        this.attackRange = attackRange;
    }

    ////////////////////////// add stats after lvl up ////////////////////////////////////////////

    private boolean getLvlUp()
    {
        return getLvl() == getLvl_to_compare();
    }
    private boolean userPickWillBeGood()
    {
        return userChoice <= 0 || userChoice >= 5;
    }
    private boolean currentPointsIsNull()
    {
        return currentPoints == 0;
    }
    private void addStrength()
    {
        Game game = new Game();
        setStrength(this.strength + 5);
        System.out.println("Strength: " + getStrength());
        currentPoints = currentPoints - 5;
        if (currentPointsIsNull()) {
            System.out.println("You don't have enough points");
            game.mainMenu();
        }
    }
    private void addDexterity()
    {
        Game game = new Game();
        setDexterity(this.dexterity + 5);
        System.out.println("Dexterity: " + getDexterity());
        currentPoints = currentPoints - 5;
        if (currentPointsIsNull()) {
            System.out.println("You don't have enough points");
            game.mainMenu();
        }
    }
    private void addIntelligence()
    {
        Game game = new Game();
        setIntelligence(this.intelligence + 5);
        System.out.println("Intelligence:" + getIntelligence());
        currentPoints = currentPoints - 5;
        if (currentPointsIsNull()) {
            System.out.println("You don't have enough points");
            game.mainMenu();
        }
    }
    private void menuForAddingStats()
    {
        currentPoints =10;
        System.out.println("Your experience points " + currentPoints);
        System.out.println("Your stats for change:");
        System.out.println("Strength: " + getStrength());
        System.out.println("Dexterity: " + getDexterity());
        System.out.println("Intelligence: " + getIntelligence());
        System.out.println("Add stats points");
        System.out.println("1.Strength (cost=5pts)");
        System.out.println("2.Dexterity (cost=5pts)");
        System.out.println("3.Intelligence (cost=5pts)");
        System.out.println("4.Back to the menu");

    }
    private void userPick()
    {
        Scanner scanner = new Scanner(System.in);
        userChoice = scanner.nextInt();
        while (userPickWillBeGood())
        {
            System.out.println("Your number pick is wrong. Try again");
            addStats();
        }
        switch (userChoice)
        {
            case 1 -> addStrength();
            case 2 -> addDexterity();
            case 3 -> addIntelligence();
            case 4 -> System.out.println("Back to menu");
        }
    }

    public void addStats()
    {
        if (getLvlUp()) {
            menuForAddingStats();
            userPick();
        }
        else {
            System.out.println("You need " + (100 - getExp()) + " experience points to next level");
        }
    }
    public void showStats()
    {
        System.out.println("Strength: " + this.strength);
        System.out.println("Dexterity: " + this.dexterity);
        System.out.println("Intelligence: " + this.intelligence);
        System.out.println("HP: " + this.hp);
        System.out.println("MP: " + this.mp);
        System.out.println("Dodge: " + this.dodge);
        System.out.println("Armor: " + this.armor);
        System.out.println("Critical attack chance: " + this.criticalChance);
    }
    public void setDuelStats()
    {
        DuelStats duelStats=new DuelStats();
        duelStats.setCurrentStr(strength);
        duelStats.setCurrentDex(dexterity);
        duelStats.setCurrentInt(intelligence);
        duelStats.setCurrentHP(hp);
        duelStats.setCurrentMP(mp);
        duelStats.setCurrentDodge(dodge);
        duelStats.setCurrentArm(armor);
        duelStats.setCurrentCritC(criticalChance);
        duelStats.setAttackRange(attackRange);
    }

}