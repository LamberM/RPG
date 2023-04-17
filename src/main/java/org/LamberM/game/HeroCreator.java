package org.LamberM.game;

import lombok.Setter;
import org.LamberM.character.Assassin;
import org.LamberM.character.Character;
import org.LamberM.character.Sorcerer;
import org.LamberM.character.Warrior;
import org.LamberM.stats.StatsShower;
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
    private SystemOutWriter outWriter;
    @Setter // for tests - setter method injection
    private StatsShower statsShower;

    public HeroCreator() {
        classMenuChooser = new MenuChooser(new SystemInReader(), List.of("1.Warrior", "2.Assassin", "3.Sorcerer", "4.Exit the game"));
        outWriter = new SystemOutWriter();
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
        outWriter.setText("Enter your character's name");
        outWriter.show();
        return inputReader.read();
    }

    private Character askForHeroClass(String name) {
        outWriter.setText("Choose a class");
        int userChoice = classMenuChooser.userPick();
        switch (userChoice) {
            case 1 -> {
                outWriter.setText("You chose a warrior");
                outWriter.show();
                return new Warrior(name);
            }
            case 2 -> {
                outWriter.setText("You chose a assassin");
                outWriter.show();
                return new Assassin(name);
            }
            case 3 -> {
                outWriter.setText("You chose a sorcerer");
                outWriter.show();
                return new Sorcerer(name);
            }
            default -> throw new IllegalArgumentException("Should never happen, because user must correct pick");
        }

    }

}