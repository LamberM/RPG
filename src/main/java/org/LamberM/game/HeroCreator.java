package org.LamberM.game;

import org.LamberM.character.Assassin;
import org.LamberM.character.Character;
import org.LamberM.character.Sorcerer;
import org.LamberM.character.Warrior;
import org.LamberM.utils.InputReader;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;

public class HeroCreator {

    final private MenuChooser classMenuChooser;

    public HeroCreator() {
        classMenuChooser = new MenuChooser(new SystemInReader(), List.of("1.Warrior", "2.Assassin", "3.Sorcerer", "4.Exit the game"));
    }

    public Character createHero() {
        String name = askForName();
        return askForHeroClass(name);
    }

    private String askForName() {
        InputReader inputReader = new SystemInReader();
        System.out.println("Enter your character's name");
        return inputReader.read();
    }

    private Character askForHeroClass(String name) {
        System.out.println("Choose a class");
        int userChoice = classMenuChooser.userPick();
        switch (userChoice) {
            case 1 -> {
                System.out.println("You chose a warrior");
                return new Warrior(name);
            }
            case 2 -> {
                System.out.println("You chose a assassin");
                return new Assassin(name);
            }
            case 3 -> {
                System.out.println("You chose a sorcerer");
                return new Sorcerer(name);
            }
            default -> throw new IllegalArgumentException("Should never happen");
        }

    }

}