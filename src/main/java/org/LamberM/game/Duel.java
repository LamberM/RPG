package org.LamberM.game;


import org.LamberM.character.Character;

public class Duel {

    private final Character enemy;
    private final Character myHero;

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
            System.out.println("END GAME");
        } else {
            System.out.println("You won");
            Level level = new Level();
            level.addExp();
            Journey journey = new Journey(myHero);
            journey.mainMenu();
        }
    }

    private boolean heroWin() {
        return enemy.getDuelStats().getDuelHP() <= 0;
    }

    private boolean enemyWin() {
        return myHero.getDuelStats().getDuelHP() <= 0;
    }


}
