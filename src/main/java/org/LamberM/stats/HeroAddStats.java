package org.LamberM.stats;

import lombok.Getter;
import lombok.Setter;
import org.LamberM.character.Character;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;
import org.LamberM.utils.SystemOutWriter;

import java.util.List;

public class HeroAddStats {
    @Setter // for tests - setter method injection
    private MenuChooser addStatsMenuChooser;
    @Setter // for tests - setter method injection
    private SystemOutWriter outWriter;
    @Getter
    @Setter // for tests
    private int currentPoints = 10;


    public HeroAddStats() {
        outWriter = new SystemOutWriter();
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
        outWriter.setText("Your experience points " + currentPoints);
        outWriter.show();
        outWriter.setText("Your stats for change:");
        outWriter.show();
        outWriter.setText("Strength: " + myHero.getStats().getStrength());
        outWriter.show();
        outWriter.setText("Dexterity: " + myHero.getStats().getDexterity());
        outWriter.show();
        outWriter.setText("Intelligence: " + myHero.getStats().getIntelligence());
        outWriter.show();
        outWriter.setText("Add stats points");
        outWriter.show();
        int userChoice = addStatsMenuChooser.userPick();
        switch (userChoice) {
            case 1 -> addStrength(myHero);
            case 2 -> addDexterity(myHero);
            case 3 -> addIntelligence(myHero);
            case 4 -> {
                outWriter.setText("Back to menu");
                outWriter.show();
            }
        }

    }

    public boolean currentPointsEqualsZero() {
        return currentPoints == 0;
    }

    private void addStrength(Character myHero) {
        if (currentPointsEqualsZero()) {
            outWriter.setText("You don't have enough points");
            outWriter.show();
        } else {
            myHero.getStats().setStrength(myHero.getStats().getStrength() + 5);
            outWriter.setText("Strength: " + myHero.getStats().getStrength());
            outWriter.show();
            currentPoints = currentPoints - 5;
        }
    }

    private void addDexterity(Character myHero) {
        if (currentPointsEqualsZero()) {
            outWriter.setText("You don't have enough points");
            outWriter.show();
        } else {
            myHero.getStats().setDexterity(myHero.getStats().getDexterity() + 5);
            outWriter.setText("Dexterity: " + myHero.getStats().getDexterity());
            outWriter.show();
            currentPoints = currentPoints - 5;
        }
    }

    private void addIntelligence(Character myHero) {
        if (currentPointsEqualsZero()) {
            outWriter.setText("You don't have enough points");
            outWriter.show();
        } else {
            myHero.getStats().setIntelligence(myHero.getStats().getIntelligence() + 5);
            outWriter.setText("Intelligence:" + myHero.getStats().getIntelligence());
            outWriter.show();
            currentPoints = currentPoints - 5;
        }
    }

}
