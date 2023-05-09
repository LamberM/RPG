package org.LamberM.game;


import lombok.Setter;
import org.LamberM.character.Character;
import org.LamberM.utils.OutputWriter;
import org.LamberM.utils.SystemOutWriter;

import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;

public class OffensiveRoundMaker {

    @Setter // - for tests - Setter Method Injection
    private OutputWriter outputWriter;
    private int criticalChance;
    private int attackChance;
    private int dodgeChance;

    public OffensiveRoundMaker() {
        outputWriter = new SystemOutWriter();
    }

    public void attack(Character attacker , Character defender) {
        attackOrCriticalOrMiss(attacker,defender);
        int attack = (20 + attacker.getDuelStats().getStrength() + attacker.getDuelStats().getDexterity()) - (defender.getDuelStats().getArmor() / 10);
        if (attackerMiss()) {
            outputWriter.show("You missed");
        } else {
            if (criticalAttack()) {
                int critical = 2 * attack;
                outputWriter.show("Critical attack for: " + critical + "!!!!!!!!!!!!");
                defender.getDuelStats().setHp(defender.getDuelStats().getHp() - critical);
            } else {
                outputWriter.show("Attack for: " + attack);
                defender.getDuelStats().setHp(defender.getDuelStats().getHp() - attack);
            }
        }
    }
    public void offensiveSkills(Character myHero , Character enemy) {
            int userChoice = myHero.provideOffensiveSkillsMenu().userPick();
            Map<Integer, Runnable> offensiveSkillsMap = myHero.provideOffensiveSkills();
            Runnable offensiveSkill = offensiveSkillsMap.get(userChoice);
            if (offensiveSkill == null) {
                outputWriter.show("Back to menu");
            } else {
                offensiveSkill.run();
                attackOrCriticalOrMiss(myHero,enemy);
                int attack = - (enemy.getDuelStats().getArmor() / 10);
                if (attackerMiss()){
                    outputWriter.show("You missed");
                }
                else {
                    if (!criticalAttack()){
                        outputWriter.show("Attack for: " + attack);
                        enemy.getDuelStats().setHp(enemy.getDuelStats().getHp() - attack );
                    }
                    else {
                        int critical = 2 * attack;
                        outputWriter.show("Critical attack for: " + critical + "!!!!!!!!!!!!");
                        enemy.getDuelStats().setHp(enemy.getDuelStats().getHp() - critical );
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
