package org.LamberM.stats;

import lombok.Getter;
import org.LamberM.game.Journey;
import org.LamberM.game.Level;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;

public class AddStats {
    private final MenuChooser addStatsMenuChooser = new MenuChooser(new SystemInReader(),
            List.of(
                    "1.Strength (cost=5pts)",
                    "2.Dexterity (cost=5pts)",
                    "3.Intelligence (cost=5pts)",
                    "4.Back to the menu"
            )
    );
    Journey journey = new Journey();
    Level level = new Level();
    @Getter
    private int currentPoints=0;
    private boolean currentPointsIsNull()
    {
        return currentPoints == 0;
    }

    private void addStrength()
    {
        if (currentPointsIsNull())
        {
            level.setLvlToCompare(level.getLvl()+1);
            System.out.println("You don't have enough points");
            journey.mainMenu();
        }
        else {
            journey.createHero.myHero.getStats().setStrength(journey.createHero.myHero.getStats().getStrength() + 5);
            System.out.println("Strength: " + journey.createHero.myHero.getStats().getStrength());
            currentPoints = currentPoints - 5;
        }
    }
    private void addDexterity()
    {
        if (currentPointsIsNull())
        {
            level.setLvlToCompare(level.getLvl()+1);
            System.out.println("You don't have enough points");
            journey.mainMenu();
        }
        else {
            journey.createHero.myHero.getStats().setDexterity(journey.createHero.myHero.getStats().getDexterity() + 5);
            System.out.println("Dexterity: " + journey.createHero.myHero.getStats().getDexterity());
            currentPoints = currentPoints - 5;
        }
    }
    private void addIntelligence()
    {
        if (currentPointsIsNull())
        {
            level.setLvlToCompare(level.getLvl()+1);
            System.out.println("You don't have enough points");
            journey.mainMenu();
        }
        else {
            journey.createHero.myHero.getStats().setIntelligence(journey.createHero.myHero.getStats().getIntelligence() + 5);
            System.out.println("Intelligence:" + journey.createHero.myHero.getStats().getIntelligence());
            currentPoints = currentPoints - 5;
        }
    }
    public void addStats()
    {
        level.lvlUP();
        if (level.getLvlUp()) {
            currentPoints = 10;
            System.out.println("Your experience points " + currentPoints);
            System.out.println("Your stats for change:");
            System.out.println("Strength: " + journey.createHero.myHero.getStats().getStrength());
            System.out.println("Dexterity: " + journey.createHero.myHero.getStats().getDexterity());
            System.out.println("Intelligence: " + journey.createHero.myHero.getStats().getIntelligence());
            System.out.println("Add stats points");
            int userChoice = addStatsMenuChooser.userPick();
            switch (userChoice) {
                case 1 -> addStrength();
                case 2 -> addDexterity();
                case 3 -> addIntelligence();
                case 4 -> System.out.println("Back to menu");
            }
        }
        else
        {
            System.out.println("You need " + (100 - level.getExp()) + " experience points to next level");
        }

    }
}
