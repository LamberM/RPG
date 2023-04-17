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
            outWriter.setText("RoundMaker number " + roundCounter);
            outWriter.show();
            roundMaker.playRound(myHero,enemy);
        }
        if (enemyWin(myHero)) {
            outWriter.setText("You lost");
            outWriter.show();
            outWriter.setText("GAME IS OVER");
            outWriter.show();
        } else {
            outWriter.setText("You won");
            outWriter.show();
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
