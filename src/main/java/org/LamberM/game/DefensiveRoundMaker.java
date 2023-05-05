package org.LamberM.game;

import lombok.Setter;
import org.LamberM.character.Character;
import org.LamberM.utils.SystemOutWriter;

import java.util.Map;

public class DefensiveRoundMaker {
    @Setter // for tests - setter method injection
    private SystemOutWriter outWriter;

    public DefensiveRoundMaker() {
        this.outWriter = new SystemOutWriter();
    }

    public void defensiveSkills(Character myHero) {
            int userChoice = myHero.provideDefensiveSkillsMenu().userPick();
            Map<Integer, Runnable> defensiveSkillsMap = myHero.provideDefensiveSkills();
            Runnable defensiveSkill = defensiveSkillsMap.get(userChoice);
            if (defensiveSkill == null) {
                outWriter.setText("Back to menu");
                outWriter.show();
            } else {
                defensiveSkill.run();
            }
        }

    public void rest(Character myHero) {
        int hpBeforeRest = myHero.getDuelStats().getHp();
        int mpBeforeRest = myHero.getDuelStats().getMp();
        myHero.getDuelStats().setHp(myHero.getDuelStats().getHp() + 20);
        myHero.getDuelStats().setMp(myHero.getDuelStats().getMp() + 20);

        if (myHero.getDuelStats().getHp() >=hpBeforeRest || myHero.getDuelStats().getMp()>= mpBeforeRest) {
            myHero.getDuelStats().setHp(hpBeforeRest);
            myHero.getDuelStats().setMp(mpBeforeRest);
        } else {
            outWriter.setText("Your HP: " + myHero.getDuelStats().getHp()+
            "\nYour MP: " + myHero.getDuelStats().getMp());
            outWriter.show();
        }
    }

}
