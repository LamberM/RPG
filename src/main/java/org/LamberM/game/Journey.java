package org.LamberM.game;

import lombok.Setter;
import org.LamberM.character.Character;
import org.LamberM.stats.StatsShower;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.OutputWriter;
import org.LamberM.utils.SystemInReader;
import org.LamberM.utils.SystemOutWriter;

import java.util.List;

public class Journey {
    @Setter // for tests - setter method injection
    private MenuChooser journeyMenuChooser;
    @Setter // for tests - setter method injection
    private OutputWriter outputWriter;
    @Setter // for tests - setter method injection
    private DuelMaker duelMaker;
    @Setter // for tests - setter method injection
    private StatsShower statsShower;

    public Journey() {
        journeyMenuChooser = new MenuChooser(new SystemInReader(), List.of("1.Fight", "2.Look at stats", "3.Add stats points", "4.Exit the game"));
        outputWriter = new SystemOutWriter();
        duelMaker = new DuelMaker();
        statsShower = new StatsShower();
    }

    public void startJourney(Character myHero, Character enemy) {
        outputWriter.show("Hello " + myHero.getName() +
                "\nAre you ready for adventure ?" +
                "\nYour choice possibilities:");
        int userChoice = journeyMenuChooser.userPick();
        switch (userChoice) {
            case 1 -> duelMaker.duelMenu(myHero, enemy);
            case 2 -> statsShower.showStats(myHero.getStats());
//            case 3 -> {
//                Level level = new Level();
//                level.lvlUP();
//                if (!level.getLvlUp()) {
//                    System.out.println("You don't have level up");
//                } else {
//                    HeroAddStats heroAddStats = new HeroAddStats(myHero);
//                    while (!heroAddStats.currentPointsIsNull()) {
//                        heroAddStats.addStats();
//                    }
//                    level.setLvlToCompare(level.getLvl() + 1);
//                }
//            }
            case 4 -> outputWriter.show("See you later, bye");
        }
    }
}
