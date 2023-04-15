package org.LamberM.game;


import lombok.Setter;
import org.LamberM.character.Character;

public class Duel {
    @Setter // for tests - setter method injection
    private  Character enemy;
    @Setter // for tests - setter method injection
    private  Character myHero;

    public Duel(Character myHeroParameters, Character enemyParameters) {
        this.myHero = myHeroParameters;
        this.enemy = enemyParameters;

    }

    public void duelMenu() {
        int roundCounter = 0;
        while (!heroWin() || !enemyWin()) {
            roundCounter++;
            System.out.println("Round number " + roundCounter);
            Round round = new Round(myHero, enemy, roundCounter);
            round.playRound();
        }
        if (enemyWin()) {
            System.out.println("You lost");
            System.out.println("GAME IS OVER");
        } else {
            System.out.println("You won");
//            Level level = new Level();
//            level.addExp();
            Journey journey = new Journey(myHero);
            journey.startJourney();
        }
    }

    private boolean heroWin() {
        return enemy.getDuelStats().getHp() <= 0;
    }

    private boolean enemyWin() {
        return myHero.getDuelStats().getHp() <= 0;
    }


}
