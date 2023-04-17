package org.LamberM.game;


import lombok.Setter;
import org.LamberM.character.Character;
import org.LamberM.utils.SystemOutWriter;

public class DuelMaker {
    @Setter // for tests - setter method injection
    private RoundMaker roundMaker;
    @Setter // for tests - setter method injection
    private SystemOutWriter outWriter;
    @Setter // for tests - setter method injection
    private Journey journey;
    public DuelMaker() {
        roundMaker= new RoundMaker();
        outWriter = new SystemOutWriter();
        journey = new Journey();
    }

    public void duelMenu(Character myHero , Character enemy) {
        int roundCounter = 0;
        while (!heroWin(enemy) || !enemyWin(myHero)) {
            roundCounter++;
            outWriter.show("RoundMaker number " + roundCounter);
            roundMaker.playRound(myHero,enemy);
        }
        if (enemyWin(myHero)) {
            outWriter.show("You lost");
            outWriter.show("GAME IS OVER");
        } else {
            System.out.println("You won");
//            Level level = new Level();
//            level.addExp();
            journey.startJourney(myHero);
        }
    }

    private boolean heroWin(Character enemy) {
        return enemy.getDuelStats().getHp() <= 0;
    }

    private boolean enemyWin(Character myHero) {
        return myHero.getDuelStats().getHp() <= 0;
    }


}
