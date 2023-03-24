package org.LamberM.game;

import lombok.Getter;
import lombok.Setter;
import org.LamberM.character.Assassin;
import org.LamberM.character.Character;
import org.LamberM.character.Sorcerer;
import org.LamberM.character.Warrior;
import org.LamberM.utils.InputReader;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.ArrayList;
import java.util.List;

public class CreateHero {
    private InputReader inputReader;
    public Character myHero;
    @Getter
    @Setter
    private String name;

    final private MenuChooser classMenuChooser = new MenuChooser(new SystemInReader(),
            List.of(
                    "1.Warrior",
                    "2.Assassin",
                    "3.Sorcerer",
                    "4.Exit the game"
            )
    );

    public void addName()
    {
        inputReader = new SystemInReader();
        System.out.println("Enter your character's name");
        this.name = inputReader.read();
    }

    public void pickClass()
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