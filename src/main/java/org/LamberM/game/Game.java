package org.LamberM.game;

import org.LamberM.classes.Assassin;
import org.LamberM.classes.Classes;
import org.LamberM.classes.Sorcerer;
import org.LamberM.classes.Warrior;
import org.LamberM.enemy.Enemy;

import java.util.Scanner;

public class Game {
    private String Name;
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    Scanner scanner = new Scanner(System.in);
    Classes myHero;
    int userChoice;
    public int range=2;

    public void game() {
        addName();
        infoAboutClass();
        pickClass();
    }
    public void addName(){
        System.out.println("Enter your character's name");
        String name = scanner.nextLine();
        setName(name);
    }
    public void infoAboutClass(){
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
    public void pickClass(){
        System.out.println("Choose a class");
        System.out.println("1.classes.Warrior");
        System.out.println("2.classes.Assassin");
        System.out.println("3.classes.Sorcerer");
        System.out.println("4.Exit the game");
        userChoice = scanner.nextInt();

        if (userChoice > 0 && userChoice < 5) {
            switch (userChoice) {
                case 1 -> {
                    System.out.println("You chose a warrior");
                    myHero=new Warrior();
                    mainMENU();
                }
                case 2 -> {
                    System.out.println("You chose a assassin");
                    myHero=new Assassin();
                    mainMENU();
                }
                case 3 -> {
                    System.out.println("You chose a sorcerer");
                    myHero=new Sorcerer();
                    mainMENU();
                }
                case 4 -> {}
            }
        }
        else {
            pickClass();
            System.out.println("Try again");
        }
    }
    public void mainMENU() {
            System.out.println("Hello " + getName());
            System.out.println("Are you ready for adventure ?");
            System.out.println("Your choice possibilities:");
            System.out.println("1.Fight");
            System.out.println("2.Look at stats");
            System.out.println("3.Add stats points");
            System.out.println("4.Exit the game");
            userChoice = scanner.nextInt();
            if (userChoice > 0 && userChoice < 5) {
                switch (userChoice) {
                    case 1 -> duelMENU();
                    case 2 -> {
                        myHero.showStats();
                        mainMENU();
                    }
                    case 3 -> {
                        myHero.lvlUP();
                        mainMENU();
                    }
                    case 4 ->{}
                }
            } else {
                System.out.println("Try again");
                mainMENU();
            }
        }
    public void duelMENU() {
            Enemy enemy = new Enemy();
            enemy.duelStats();
            myHero.duelStats();
            System.out.println("1.Attack");
            System.out.println("2.Skills");
            System.out.println("3.Step forward");
            System.out.println("4.Step back");
            System.out.println("5.Rest");
            userChoice = scanner.nextInt();
            if (userChoice > 0 && userChoice < 6) {
                switch (userChoice) {
                    case 1 ->{
                    if (range <= myHero.stats.getAttackRange()){
                        myHero.attack();
                        enemy.attack();
                        duelMENU();
                        }
                    else {
                        System.out.println("You can't have to hit enemy. Your attack range is too small");
                        duelMENU();
                        }
                    }
                    case 2-> {
                        if (myHero.stats.getCurrentMP()>=20){
                            myHero.skills();
                            enemy.attack();
                            duelMENU();

                        }
                        else {
                            System.out.println("You don't have enough mana points");
                            duelMENU();
                        }
                    }
                    case 3->{
                        range=range-1;
                        enemy.attack();
                        duelMENU();
                    }
                    case 4->{
                        range=range+1;
                        enemy.attack();
                        duelMENU();
                    }
                    case 5-> {
                        myHero.rest();
                        enemy.attack();
                        duelMENU();

                    }
                }
            }
            else{
                System.out.println("You entered the wrong number. Try again");
                duelMENU();
            }
            // dodać zwycięzce, expa ,lvl up'y
        }
    }

