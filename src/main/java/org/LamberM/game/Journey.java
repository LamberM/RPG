package org.LamberM.game;

import org.LamberM.stats.AddStats;
import org.LamberM.stats.ShowStats;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;

public class Journey {

    private final MenuChooser mainMenuChooser = new MenuChooser(new SystemInReader(),
            List.of(
                    "1.Fight",
                    "2.Look at stats",
                    "3.Add stats points",
                    "4.Exit the game"
            )
    );
    public CreateHero createHero = new CreateHero();


    public void mainMenu()
    {
        System.out.println("Hello " + createHero.getName());
        System.out.println("Are you ready for adventure ?");
        System.out.println("Your choice possibilities:");
        int userChoice = mainMenuChooser.userPick();
        switch (userChoice)
        {
            case 1 -> {
                Duel duel  = new Duel();
                duel.duelMenu();
            }
            case 2 ->
            {
                ShowStats showStats = new ShowStats();
                showStats.showStats();
            }
            case 3 ->
            {
                AddStats addStats = new AddStats();
                addStats.addStats();
            }
            case 4 -> System.out.println("See you later, bye");
        }
    }


}
