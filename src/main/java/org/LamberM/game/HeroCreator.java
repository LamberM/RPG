package org.LamberM.game;

import lombok.Setter;
import org.LamberM.character.Assassin;
import org.LamberM.character.Character;
import org.LamberM.character.Sorcerer;
import org.LamberM.character.Warrior;
import org.LamberM.stats.StatsShower;
import org.LamberM.utils.*;

import java.util.List;

public class HeroCreator {

    @Setter // for tests - setter method injection
    private MenuChooser classMenuChooser;
    @Setter // for tests - setter method injection
    private InputReader inputReader;
    private final OutputWriter outputWriter;
    @Setter // for tests - setter method injection
    private StatsShower statsShower;

    public HeroCreator() {
        classMenuChooser = new MenuChooser(new SystemInReader(), List.of("1.Warrior", "2.Assassin", "3.Sorcerer", "4.Exit the game"));
        outputWriter = new SystemOutWriter();
        inputReader = new SystemInReader();
        statsShower = new StatsShower();
    }

    public Character createHero() {
        statsShower.showStats(Assassin.assassinDefaultStats());
        statsShower.showStats(Sorcerer.sorcererDefaultStats());
        statsShower.showStats(Warrior.warriorDefaultStats());
        String name = askForName();
        return askForHeroClass(name);
    }

    private String askForName() {
        outputWriter.show("Enter your character's name");
        return inputReader.read();
    }

    private Character askForHeroClass(String name) {
        outputWriter.show("Choose a class");
        int userChoice = classMenuChooser.userPick();
        switch (userChoice) {
            case 1 -> {
                outputWriter.show("You chose a warrior");
                return new Warrior(name);
            }
            case 2 -> {
                outputWriter.show("You chose a assassin");
                return new Assassin(name);
            }
            case 3 -> {
                outputWriter.show("You chose a sorcerer");
                return new Sorcerer(name);
            }
            default -> throw new IllegalArgumentException("Should never happen, because user must correct pick");
        }

    }

}