package org.LamberM.game;

import lombok.Setter;
import org.LamberM.character.Character;
import org.LamberM.stats.ShowStats;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;

public class Journey {
    @Setter // for tests - setter method injection
    private MenuChooser journeyMenuChooser;
    @Setter // for tests - setter method injection
    private MenuChooser newJourneyMenuChooser;
    @Setter // for tests - setter method injection
    private  Character myHero;

    public Journey(Character myHero) {
        this.myHero = myHero;
        journeyMenuChooser = new MenuChooser(new SystemInReader(), List.of("1.Fight", "2.Look at stats", "3.Add stats points", "4.Exit the game"));
    }

    public void startJourney() {
        System.out.println("Hello " + myHero.getName());
        System.out.println("Are you ready for adventure ?");
        System.out.println("Your choice possibilities:");
        int userChoice = journeyMenuChooser.userPick();
        switch (userChoice) {
            case 1 -> {
                EnemyCreator enemyCreator = new EnemyCreator();
                Character enemy = enemyCreator.createEnemy();
                Duel duel = new Duel(myHero, enemy);
                duel.duelMenu();
            }
            case 2 -> {
                ShowStats show = new ShowStats();
                show.showStats(myHero);
            }
            case 3 -> {
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
            }
            case 4 -> System.out.println("See you later, bye");
        }
    }
}
