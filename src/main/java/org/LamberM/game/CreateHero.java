package org.LamberM.game;

import lombok.Getter;
import org.LamberM.characters.Assassin;
import org.LamberM.characters.Characters;
import org.LamberM.characters.Sorcerer;
import org.LamberM.characters.Warrior;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;

public class CreateHero {
    CreateHero()
    {
        addName();
        infoAboutClass();
        pickClass();
    }
    Characters myHero;
    @Getter
    private String name;

    private MenuChooser classMenuChooser = new MenuChooser(new SystemInReader(),
            List.of(
        "1.Warrior",
        "2.Assassin",
        "3.Sorcerer",
        "4.Exit the game"
            )
    );

    public void addName()
    {
        System.out.println("Enter your character's name");
        SystemInReader reader = new SystemInReader();
        name = String.valueOf(reader);
    }
    public void infoAboutClass()
    {
        Warrior warrior=new Warrior();
        Assassin assassin= new Assassin();
        Sorcerer sorcerer= new Sorcerer();
        System.out.println("All class stats:");
        System.out.println("Warrior stats: ");
        warrior.stats.showStats();
        System.out.println("Assassin stats:");
        assassin.stats.showStats();
        System.out.println("Sorcerer stats: ");
        sorcerer.stats.showStats();
    }
    private void pickClass()
    {
        System.out.println("Choose a class");
        int userChoice = classMenuChooser.userPick();
            switch (userChoice)
            {
                case 1 ->
                {
                    System.out.println("You chose a warrior");
                    myHero = new Warrior();
                }
                case 2 ->
                {
                    System.out.println("You chose a assassin");
                    myHero = new Assassin();
                }
                case 3 ->
                {
                    System.out.println("You chose a sorcerer");
                    myHero = new Sorcerer();
                }
                case 4 -> System.out.println("See you later, bye");
            }

    }
}
