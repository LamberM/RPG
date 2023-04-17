package org.LamberM.game;

import lombok.Setter;
import org.LamberM.character.Character;
import org.LamberM.utils.SystemOutWriter;

import java.util.Map;

public class DefensiveRoundMaker {
    @Setter // for tests - setter method injection
    private SystemOutWriter out;

    public DefensiveRoundMaker() {
        this.out = new SystemOutWriter();
    }

    public int defensiveSkills(Character myHero) {
        if (myHeroCanUseSkill(myHero)) {
            int userChoice = myHero.provideDefensiveSkillsMenu().userPick();
            Map<Integer, Runnable> defensiveSkillsMap = myHero.provideDefensiveSkills();
            Runnable defensiveSkill = defensiveSkillsMap.get(userChoice);
            if (defensiveSkill == null) {
                out.show("Back to menu");
                return 9999;
            } else {
                defensiveSkill.run();
                return 0;
            }
        } else {
            out.show("You don't have enough mana points (20MP) ");
            out.show("Back to menu");
            return 9999;
        }
    }

    public void rest(Character myHero) {
        int currentHp = myHero.getDuelStats().getHp() + 20;
        int currentMp = myHero.getDuelStats().getMp() + 20;

        if (currentHp >= myHero.getDuelStats().getHp() || currentMp >= myHero.getDuelStats().getMp()) {
            myHero.getDuelStats().setHp(myHero.getDuelStats().getHp());
            myHero.getDuelStats().setMp(myHero.getDuelStats().getMp());
        } else {
            out.show("Your HP: " + myHero.getDuelStats().getHp());
            out.show("Your MP: " + myHero.getDuelStats().getMp());
        }
    }

    private boolean myHeroCanUseSkill(Character myHero) {
        return myHero.getDuelStats().getMp() >= 20;
    }

}
