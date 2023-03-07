package org.LamberM.game;


import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;

public class Journey {
    Journey()
    {
        new CreateHero();
    }
    CreateHero hero= new CreateHero();
    Duel duel = new Duel();
    private MenuChooser mainMenuChooser = new MenuChooser(new SystemInReader(),
            List.of(
                    "1.Fight",
                    "2.Look at stats",
                    "3.Add stats points",
                    "4.Exit the game"
            )
            );
    private MenuChooser addStatsMenuChooser = new MenuChooser(new SystemInReader(),
            List.of(
                    "1.Strength (cost=5pts)",
                    "2.Dexterity (cost=5pts)",
                    "3.Intelligence (cost=5pts)",
                    "4.Back to the menu"
            )
            );
    private int exp = 0;
    private int lvl = 1;
    private int lvl_to_compare = 2;
    private int currentPoints;
    public void mainMenu()
    {
        System.out.println("Hello " + hero.getName());
        System.out.println("Are you ready for adventure ?");
        System.out.println("Your choice possibilities:");
        int userChoice = mainMenuChooser.userPick();
        switch (userChoice)
        {
            case 1 -> duel.duelMenu();
            case 2 ->
            {
                showStats();
            }
            case 3 ->
            {
                addStats();
            }
            case 4 -> System.out.println("See you later, bye");
        }
    }

    public void showStats()
    {
        hero.myHero.showStats();
        mainMenu();
    }
    private boolean getLvlUp()
    {
        return lvl == lvl_to_compare;
    }

    private boolean currentPointsIsNull()
    {
        return currentPoints == 0;
    }

    void addStrength()
    {
        hero.myHero.stats.setStrength(hero.myHero.stats.getStrength() + 5);
        System.out.println("Strength: " + hero.myHero.stats.getStrength());
        currentPoints = currentPoints - 5;
        if (currentPointsIsNull())
        {
            System.out.println("You don't have enough points");
            mainMenu();
        }
    }
    void addDexterity()
    {
        hero.myHero.stats.setDexterity(hero.myHero.stats.getDexterity() + 5);
        System.out.println("Dexterity: " + hero.myHero.stats.getDexterity());
        currentPoints = currentPoints - 5;
        if (currentPointsIsNull())
        {
            System.out.println("You don't have enough points");
            mainMenu();
        }
    }
    void addIntelligence()
    {
        hero.myHero.stats.setIntelligence(hero.myHero.stats.getIntelligence() + 5);
        System.out.println("Intelligence:" + hero.myHero.stats.getIntelligence());
        currentPoints = currentPoints - 5;
        if (currentPointsIsNull())
        {
            System.out.println("You don't have enough points");
            mainMenu();
        }
    }
    private void menuForAddingStats()
    {
        currentPoints =10;
        System.out.println("Your experience points " + currentPoints);
        System.out.println("Your stats for change:");
        System.out.println("Strength: " + hero.myHero.stats.getStrength());
        System.out.println("Dexterity: " + hero.myHero.stats.getDexterity());
        System.out.println("Intelligence: " + hero.myHero.stats.getIntelligence());
        System.out.println("Add stats points");
        int userChoice = mainMenuChooser.userPick();
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
        if (getLvlUp())
        {
            menuForAddingStats();
        }
        else
        {
            System.out.println("You need " + (100 - exp) + " experience points to next level");
        }
    }
}
