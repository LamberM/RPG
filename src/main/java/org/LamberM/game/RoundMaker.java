package org.LamberM.game;

import lombok.Setter;
import org.LamberM.character.Character;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;
import org.LamberM.utils.SystemOutWriter;

import java.util.List;

public class RoundMaker {
    @Setter // for tests - setter method injection
    private MenuChooser duelMenuChooser;
    @Setter // for tests - setter method injection
    private OffensiveRoundMaker offensiveRoundMaker;
    @Setter // for tests - setter method injection
    private DefensiveRoundMaker defensiveRoundMaker;
    @Setter // for tests - setter method injection
    private SystemOutWriter outWriter;
    @Setter // for tests
    private int range = 3;


    public RoundMaker() {
        offensiveRoundMaker = new OffensiveRoundMaker();
        defensiveRoundMaker = new DefensiveRoundMaker();
        duelMenuChooser = new MenuChooser(new SystemInReader(),
                List.of(
                        "1.Attack",
                        "2.Offensive skills",
                        "3.Defensive skills",
                        "4.Step forward",
                        "5.Rest"
                )
        );
    }

    public void playRound(Character myHero, Character enemy) {
        heroStatsInDuel(myHero);
        enemyStatsInDuel(enemy);
        int userChoice = duelMenuChooser.userPick();
        switch (userChoice) {
            case 1 -> {
                myHeroAttack(myHero,enemy);
                enemyAttack(enemy,myHero);
            }
            case 2 -> {
                offensiveSkillsRound(myHero,enemy);
                enemyAttack(enemy,myHero);
            }
            case 3 -> {
                defensiveSkillsRound(myHero,enemy);
                enemyAttack(enemy,myHero);
            }
            case 4 -> {
                range = range - 1;
                enemyAttack(enemy,myHero);
            }
            case 5 -> defensiveRoundMaker.rest(myHero);
        }
    }

    private void heroStatsInDuel(Character myHero) {
        outWriter.setText("My hero");
        outWriter.show();
        outWriter.setText("HP: " + myHero.getDuelStats().getHp() + " MP: " + myHero.getDuelStats().getMp());
        outWriter.show();
    }

    private void enemyStatsInDuel(Character enemy) {
        outWriter.setText("Enemy");
        outWriter.show();
        outWriter.setText("HP: " + enemy.getDuelStats().getHp());
        outWriter.show();
    }

    private void enemyAttack(Character enemy,Character myHero) {
        if (enemyCanAttack(enemy)) {
            offensiveRoundMaker.attack(enemy,myHero);
        } else {
            outWriter.setText("I can't have to hit enemy. My attack range is too small");
            outWriter.show();
            outWriter.setText("Step forward");
            outWriter.show();
            range = range - 1;
        }
    }

    private boolean enemyCanAttack(Character enemy) {
        return enemy.getDuelStats().getAttackRange() >= range;
    }

    private void myHeroAttack(Character myHero, Character enemy) {
        if (!heroHaveAttackRange(myHero)) {
            outWriter.setText("You can't have to hit enemy. Your attack range is too small");
            outWriter.show();
            playRound(myHero,enemy);
        }
        else {
            offensiveRoundMaker.attack(myHero,enemy);
        }
    }

    private boolean heroHaveAttackRange(Character myHero) {
        return range <= myHero.getDuelStats().getAttackRange();
    }

    private void offensiveSkillsRound(Character myHero , Character enemy) {
        if (myHeroCanUseOffensiveSkill(myHero)) {
            if (heroHaveAttackRange(myHero)) {
                offensiveRoundMaker.offensiveSkills(myHero);
                enemyAttack(enemy,myHero);
            } else {
                outWriter.setText("You can't have to hit enemy. Your attack range is too small");
                outWriter.show();
                playRound(myHero,enemy);
            }
        } else {
            outWriter.setText("Not enough mana points to use offensive skills");
            outWriter.show();
            playRound(myHero,enemy);
        }
    }

    private void defensiveSkillsRound(Character myHero, Character enemy) {
        if (myHeroCanUseDefensiveSkill(myHero)) {
            defensiveRoundMaker.defensiveSkills(myHero);
            enemyAttack(enemy,myHero);
        } else {
            outWriter.setText("Not enough mana points to use defensive skills");
            outWriter.show();
            playRound(myHero,enemy);
        }
    }

    private boolean myHeroCanUseOffensiveSkill(Character myHero) {
        return (offensiveRoundMaker.offensiveSkills(myHero) >= 0 && offensiveRoundMaker.offensiveSkills(myHero) < 9999);
    }

    private boolean myHeroCanUseDefensiveSkill(Character myHero) {
        return (defensiveRoundMaker.defensiveSkills(myHero) >= 0 && defensiveRoundMaker.defensiveSkills(myHero) < 9999);
    }


}
