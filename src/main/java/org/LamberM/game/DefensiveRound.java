package org.LamberM.game;

import org.LamberM.character.Character;

public class DefensiveRound {
    private final Character myHero;

    public DefensiveRound(Character myHeroParameters) {
        this.myHero = myHeroParameters;
    }

    public int defensiveSkills() {
        return myHero.defensiveSkillsMenu();
    }

    public void rest() {
        myHero.rest();
    }


}
