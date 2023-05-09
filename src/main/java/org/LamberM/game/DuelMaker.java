package org.LamberM.game;


import lombok.Setter;
import org.LamberM.character.Character;
import org.LamberM.utils.OutputWriter;
import org.LamberM.utils.SystemOutWriter;

public class DuelMaker {
    @Setter // for tests - setter method injection
    private RoundMaker roundMaker;
    private final OutputWriter outputWriter;
    @Setter // for tests - setter method injection
    private Journey journey;

    public DuelMaker() {
        roundMaker = new RoundMaker();
        outputWriter = new SystemOutWriter();
    }

    public void duelMenu(Character myHero, Character enemy) {
        int roundCounter = 0;
        while (!characterIsDead(enemy) && !characterIsDead(myHero)) {
            roundCounter++;
            outputWriter.show("Round number " + roundCounter);
            roundMaker.playRound(myHero, enemy);
        }
        if (characterIsDead(myHero)) {
            outputWriter.show("You lost" +
                    "\nGAME IS OVER");
        } else {
            outputWriter.show("You won");
//            Level level = new Level();
//            level.addExp();
            journey.startJourney(myHero, enemy);
        }
    }

    private boolean characterIsDead(Character character) {
        return character.getDuelStats().getHp() <= 0;
    }


}
