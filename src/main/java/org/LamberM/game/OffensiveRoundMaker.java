package org.LamberM.game;


import lombok.Setter;
import org.LamberM.character.Character;
import org.LamberM.utils.SystemOutWriter;

import java.util.Map;
import java.util.Random;

public class OffensiveRoundMaker {
    @Setter // for tests - setter method injection
    private SystemOutWriter outWriter;
    private int criticalChance;
    private int attackChance;
    private int dodgeChance;

    public OffensiveRoundMaker() {
        this.outWriter = new SystemOutWriter();
    }

    public void attack(Character attacker , Character defender) {
        attackOrCriticalOrMiss(attacker,defender);
        int attack = 20 + attacker.getDuelStats().getStrength() + attacker.getDuelStats().getDexterity();
        if (attackerMiss()) {
            outWriter.setText("You missed");
            outWriter.show();
        } else {
            if (criticalAttack()) {
                int critical = 2 * attack;
                outWriter.setText("Critical attack for: " + critical + "!!!!!!!!!!!!");
                outWriter.show();
                defender.getDuelStats().setHp(defender.getDuelStats().getHp() - (critical - (defender.getDuelStats().getArmor() / 10)));
            } else {
                outWriter.setText("Attack for: " + attack);
                outWriter.show();
                defender.getDuelStats().setHp(defender.getDuelStats().getHp() - (attack - (defender.getDuelStats().getArmor() / 10)));
            }
        }
    }
    public void offensiveSkills(Character myHero , Character enemy) {
            int userChoice = myHero.provideOffensiveSkillsMenu().userPick();
            Map<Integer, Runnable> offensiveSkillsMap = myHero.provideOffensiveSkills();
            Runnable offensiveSkill = offensiveSkillsMap.get(userChoice);
            if (offensiveSkill == null) {
                outWriter.setText("Back to menu");
                outWriter.show();
            } else {
                offensiveSkill.run();
                attackOrCriticalOrMiss(myHero,enemy);
                if (attackerMiss()){
                    outWriter.setText("You missed");
                    outWriter.show();
                }
                else {
                    if (criticalAttack()){

                    }
                }

            }
    }

    private void attackOrCriticalOrMiss(Character attacker , Character defender) {
        Random draw = new Random();
        attackChance = attacker.getDuelStats().getDexterity() + draw.nextInt(101);
        dodgeChance = defender.getDuelStats().getDodge() + draw.nextInt(101);
        criticalChance = attacker.getDuelStats().getCriticalChance() + draw.nextInt(101);
    }
    private boolean attackerMiss() {
        return dodgeChance >= attackChance;
    }

    private boolean criticalAttack() {
        return criticalChance >= 100;
    }
}
