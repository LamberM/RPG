package org.LamberM.game;

import lombok.Getter;
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
    private final SystemOutWriter outWriter;
    @Setter // for tests
    @Getter
    private int range = 3;


    public RoundMaker() {
        offensiveRoundMaker = new OffensiveRoundMaker();
        defensiveRoundMaker = new DefensiveRoundMaker();
        outWriter = new SystemOutWriter();
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
        int tries = 0;
        roundMenu(myHero,enemy);
        int userChoice = duelMenuChooser.userPick();
        switch (userChoice) {
            case 1 -> {
                while (!myHeroHaveAttackRange(myHero)){
                    tries++;
                    outWriter.show("You can't have to hit enemy. Your attack range is too small");
                    if (tries > 5) {
                        throw new IllegalArgumentException("You made mistakes too much");
                    }
                }
                offensiveRoundMaker.attack(myHero,enemy);
                if (enemyCanAttack(enemy)){
                    offensiveRoundMaker.attack(enemy, myHero);
                }
                else {
                    range = range - 1;
                    outWriter.show("I can't attack.\nI must take step forward");
                }
            }
            case 2 -> {
                while (!myHeroCanUseSkill(myHero)||!myHeroHaveAttackRange(myHero)) {
                    tries++;
                    outWriter.show("You can't have to hit enemy. Your attack range is too small or hero don't enough mana points to use offensive skills (20MP)");
                    if (tries > 5) {
                        throw new IllegalArgumentException("You made mistakes too much");
                    }
                }
                offensiveRoundMaker.offensiveSkills(myHero,enemy);
                if (enemyCanAttack(enemy)){
                    offensiveRoundMaker.attack(enemy, myHero);
                }
                else {
                    range = range - 1;
                    outWriter.show("I can't attack.\nI must take step forward");
                }
            }
            case 3 -> {
                while (!myHeroCanUseSkill(myHero)) {
                    tries++;
                    outWriter.show("Not enough mana points to use defensive skills (20MP)");
                    if (tries > 5) {
                        throw new IllegalArgumentException("You made mistakes too much");
                    }
                    }
                    defensiveRoundMaker.defensiveSkills(myHero);
                    if (enemyCanAttack(enemy)){
                        offensiveRoundMaker.attack(enemy, myHero);
                    }
                    else {
                        range = range - 1;
                        outWriter.show("I can't attack.\nI must take step forward");
                    }
                }
            case 4 -> {
                range = range - 1;
                if (enemyCanAttack(enemy)){
                    offensiveRoundMaker.attack(enemy, myHero);
                }
                else {
                    range = range - 1;
                    outWriter.show("I can't attack.\nI must take step forward");
                }
            }
            case 5 -> {
                defensiveRoundMaker.rest(myHero);
                if (enemyCanAttack(enemy)){
                    offensiveRoundMaker.attack(enemy, myHero);
                }
                else {
                    range = range - 1;
                    outWriter.show("I can't attack.\nI must take step forward");
                }
            }
        }
    }
    private void roundMenu(Character myHero,Character enemy){
        outWriter.show("Range: " + range+"\n"+
                        "My hero"+ "\n"+ "HP: " + myHero.getDuelStats().getHp() + " MP: " + myHero.getDuelStats().getMp() +"\n"+
                "Enemy"+"\n"+"HP: " + enemy.getDuelStats().getHp());
    }
    private boolean enemyCanAttack(Character enemy) {
        return enemy.getDuelStats().getAttackRange() >= range;
    }


    private boolean myHeroHaveAttackRange(Character myHero) {
        return range <= myHero.getDuelStats().getAttackRange();
    }

    private boolean myHeroCanUseSkill(Character myHero) {
        return myHero.getDuelStats().getMp()>=20;
    }



}
