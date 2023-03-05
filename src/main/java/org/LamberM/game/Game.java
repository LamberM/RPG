package org.LamberM.game;

import lombok.Getter;
import lombok.Setter;
import org.LamberM.classes.Assassin;
import org.LamberM.classes.Classes;
import org.LamberM.classes.Sorcerer;
import org.LamberM.classes.Warrior;
import org.LamberM.enemy.Enemy;

import java.util.Scanner;

public class Game {
    @Getter
    private String name;
    public Classes myHero;
    private int userChoice;
    @Getter
    @Setter
    private int range=3;
    private boolean userPickIsWrong()
    {
        return userChoice <= 0 || userChoice >= 5;
    }
    public void game()
    {
        addName();
        infoAboutClass();
        pickClassMenu();
    }
    public void addName()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your character's name");
        name = scanner.nextLine();
    }
    public void infoAboutClass()
    {
        Warrior warrior=new Warrior();
        Assassin assassin= new Assassin();
        Sorcerer sorcerer= new Sorcerer();
        System.out.println("All class stats:");
        System.out.println("Warrior stats: ");
        warrior.showStats();
        System.out.println("Assassin stats:");
        assassin.showStats();
        System.out.println("Sorcerer stats: ");
        sorcerer.showStats();
    }
    private void pickClass()
    {
        Scanner scanner = new Scanner(System.in);
        userChoice = scanner.nextInt();

        if (userPickIsWrong())
        {
            pickClassMenu();
            System.out.println("Try again");
        }
        else
        {
            switch (userChoice)
            {
                case 1 ->
                {
                    System.out.println("You chose a warrior");
                    myHero = new Warrior();
                    mainMenu();
                }
                case 2 ->
                {
                    System.out.println("You chose a assassin");
                    myHero = new Assassin();
                    mainMenu();
                }
                case 3 ->
                {
                    System.out.println("You chose a sorcerer");
                    myHero = new Sorcerer();
                    mainMenu();
                }
                case 4 -> System.out.println("See you later, bye");
            }
        }
    }
    private void pickClassMenu()
    {
        System.out.println("Choose a class");
        System.out.println("1.Warrior");
        System.out.println("2.Assassin");
        System.out.println("3.Sorcerer");
        System.out.println("4.Exit the game");
        pickClass();
    }
    private void userPickInMainMenu()
    {
        Scanner scanner = new Scanner(System.in);
        userChoice = scanner.nextInt();
        if (userPickIsWrong())
        {
            System.out.println("Try again");
            mainMenu();
        }
        else
        {
            switch (userChoice)
            {
                case 1 -> duelMenu();
                case 2 ->
                {
                    myHero.showStats();
                    mainMenu();
                }
                case 3 ->
                {
                    myHero.lvlUP();
                    mainMenu();
                }
                case 4 -> System.out.println("See you later, bye");
            }
        }
    }
    public void mainMenu()
    {
            System.out.println("Hello " + name);
            System.out.println("Are you ready for adventure ?");
            System.out.println("Your choice possibilities:");
            System.out.println("1.Fight");
            System.out.println("2.Look at stats");
            System.out.println("3.Add stats points");
            System.out.println("4.Exit the game");
            userPickInMainMenu();
    }
    private boolean heroCanUseSkills()
    {
        return myHero.duelStats.getDuelMP()>=20;
    }
    private boolean heroCanAttack()
    {
        return range <= myHero.duelStats.getAttackRange();
    }
    private void userPickInDuelMenu()
    {
        Enemy enemy = new Enemy();
        Scanner scanner = new Scanner(System.in);
        enemy.duelStats();
        myHero.statsInDuel();
        userChoice = scanner.nextInt();
        if (userPickIsWrong())
        {
            System.out.println("You entered the wrong number. Try again");
            duelMenu();
        }
        else
        {
            switch (userChoice)
            {
                case 1 ->
                {
                    if (heroCanAttack())
                    {
                        myHero.attackMenu();
                        enemy.attack();
                        duelMenu();
                    }
                    else
                    {
                        System.out.println("You can't have to hit enemy. Your attack range is too small");
                        duelMenu();
                    }
                }
                case 2 ->
                {
                    if (heroCanUseSkills())
                    {
                        myHero.skillsMenu();
                        enemy.attack();
                        duelMenu();
                    }
                    else
                    {
                        System.out.println("You don't have enough mana points");
                        duelMenu();
                    }
                }
                case 3 ->
                {
                    range = range - 1;
                    enemy.attack();
                    duelMenu();
                }
                case 4 ->
                {
                    myHero.rest();
                    enemy.attack();
                    duelMenu();
                }
            }
        }
    }
    public void duelMenu()
    {
            System.out.println("1.Attack");
            System.out.println("2.Skills");
            System.out.println("3.Step forward");
            System.out.println("4.Rest");
            userPickInDuelMenu();
            // dodać zwycięzce, expa ,lvl up'y
    }
}

