package org.LamberM.game;

import lombok.Setter;
import org.LamberM.character.Assassin;
import org.LamberM.character.Character;
import org.LamberM.character.Sorcerer;
import org.LamberM.character.Warrior;
import org.LamberM.utils.InputReader;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;
import org.LamberM.utils.SystemOutWriter;

import java.util.List;

public class HeroCreator {

    @Setter // for tests - setter method injection
    private MenuChooser classMenuChooser;
    @Setter // for tests - setter method injection
    private InputReader inputReader;
    @Setter // for tests - setter method injection
    private SystemOutWriter out;
    public HeroCreator() {
        classMenuChooser = new MenuChooser(new SystemInReader(), List.of("1.Warrior", "2.Assassin", "3.Sorcerer", "4.Exit the game"));
        out = new SystemOutWriter();
        inputReader= new SystemInReader();
    }

    public Character createHero() {
        String name = askForName();
        return askForHeroClass(name);
    }

    private String askForName() {
        out.show("Enter your character's name");
        return inputReader.read();
    }

    private Character askForHeroClass(String name) {
        out.show("Choose a class");
        int userChoice = classMenuChooser.userPick();
        switch (userChoice) {
            case 1 -> {
                out.show("You chose a warrior");
                return new Warrior(name);
            }
            case 2 -> {
                out.show("You chose a assassin");
                return new Assassin(name);
            }
            case 3 -> {
                out.show("You chose a sorcerer");
                return new Sorcerer(name);
            }
            default -> throw new IllegalArgumentException("Should never happen, because user must correct pick");
        }

    }

}