package org.LamberM.stats;

import lombok.Getter;
import lombok.Setter;
import org.LamberM.character.Character;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.OutputWriter;
import org.LamberM.utils.SystemInReader;
import org.LamberM.utils.SystemOutWriter;

import java.util.List;

public class HeroAddStats {
    @Setter // for tests - setter method injection
    private MenuChooser addStatsMenuChooser;
    private final OutputWriter outputWriter;
    @Getter
    @Setter // for tests
    private int currentPoints = 10;


    public HeroAddStats() {
        outputWriter = new SystemOutWriter();
        addStatsMenuChooser = new MenuChooser(new SystemInReader(),
                List.of(
                        "1.Strength (cost=5pts)",
                        "2.Dexterity (cost=5pts)",
                        "3.Intelligence (cost=5pts)",
                        "4.Back to the menu"
                )
        );
    }
    public void addStats(Character myHero) {
        outputWriter.show("Your experience points " + currentPoints);
        outputWriter.show("Your stats for change:");
        outputWriter.show("Strength: " + myHero.getStats().getStrength());
        outputWriter.show("Dexterity: " + myHero.getStats().getDexterity());
        outputWriter.show("Intelligence: " + myHero.getStats().getIntelligence());
        outputWriter.show("Add stats points");
        int userChoice = addStatsMenuChooser.userPick();
        switch (userChoice) {
            case 1 -> addStrength(myHero);
            case 2 -> addDexterity(myHero);
            case 3 -> addIntelligence(myHero);
            case 4 -> {
                outputWriter.show("Back to menu");
            }
        }

    }

    public boolean currentPointsEqualsZero() {
        return currentPoints == 0;
    }

    private void addStrength(Character myHero) {
        if (currentPointsEqualsZero()) {
            outputWriter.show("You don't have enough points");
        } else {
            myHero.getStats().setStrength(myHero.getStats().getStrength() + 5);
            outputWriter.show("Strength: " + myHero.getStats().getStrength());
            currentPoints = currentPoints - 5;
        }
    }

    private void addDexterity(Character myHero) {
        if (currentPointsEqualsZero()) {
            outputWriter.show("You don't have enough points");
        } else {
            myHero.getStats().setDexterity(myHero.getStats().getDexterity() + 5);
            outputWriter.show("Dexterity: " + myHero.getStats().getDexterity());
            currentPoints = currentPoints - 5;
        }
    }

    private void addIntelligence(Character myHero) {
        if (currentPointsEqualsZero()) {
            outputWriter.show("You don't have enough points");
        } else {
            myHero.getStats().setIntelligence(myHero.getStats().getIntelligence() + 5);
            outputWriter.show("Intelligence:" + myHero.getStats().getIntelligence());
            currentPoints = currentPoints - 5;
        }
    }

}
