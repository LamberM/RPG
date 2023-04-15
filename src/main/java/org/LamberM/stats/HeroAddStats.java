package org.LamberM.stats;

import lombok.Getter;
import lombok.Setter;
import org.LamberM.character.Character;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;

public class HeroAddStats {
    @Setter // for tests - setter method injection
    private Character myHero;
    @Setter // for tests - setter method injection
    private MenuChooser addStatsMenuChooser;
    @Getter
    @Setter // for tests
    private int currentPoints = 10;

    public HeroAddStats(Character myHero) {
        this.myHero = myHero;
        currentPoints = 0;
        addStatsMenuChooser = new MenuChooser(new SystemInReader(),
                List.of(
                        "1.Strength (cost=5pts)",
                        "2.Dexterity (cost=5pts)",
                        "3.Intelligence (cost=5pts)",
                        "4.Back to the menu"
                )
        );
    }
    public void addStats() {
        System.out.println("Your experience points " + currentPoints);
        System.out.println("Your stats for change:");
        System.out.println("Strength: " + myHero.getStats().getStrength());
        System.out.println("Dexterity: " + myHero.getStats().getDexterity());
        System.out.println("Intelligence: " + myHero.getStats().getIntelligence());
        System.out.println("Add stats points");
        int userChoice = addStatsMenuChooser.userPick();
        switch (userChoice) {
            case 1 -> addStrength();
            case 2 -> addDexterity();
            case 3 -> addIntelligence();
            case 4 -> System.out.println("Back to menu");
        }

    }

    public boolean currentPointsIsNull() {
        return currentPoints == 0;
    }

    private void addStrength() {
        if (currentPointsIsNull()) {
            System.out.println("You don't have enough points");
        } else {
            myHero.getStats().setStrength(myHero.getStats().getStrength() + 5);
            System.out.println("Strength: " + myHero.getStats().getStrength());
            currentPoints = currentPoints - 5;
        }
    }

    private void addDexterity() {
        if (currentPointsIsNull()) {
            System.out.println("You don't have enough points");
        } else {
            myHero.getStats().setDexterity(myHero.getStats().getDexterity() + 5);
            System.out.println("Dexterity: " + myHero.getStats().getDexterity());
            currentPoints = currentPoints - 5;
        }
    }

    private void addIntelligence() {
        if (currentPointsIsNull()) {
            System.out.println("You don't have enough points");
        } else {
            myHero.getStats().setIntelligence(myHero.getStats().getIntelligence() + 5);
            System.out.println("Intelligence:" + myHero.getStats().getIntelligence());
            currentPoints = currentPoints - 5;
        }
    }

}
