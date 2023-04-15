package org.LamberM.game;

import lombok.Getter;
import lombok.Setter;
import org.LamberM.character.Character;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;

public class Round {
    @Setter // for tests - setter method injection

    private Character myHero;
    @Setter // for tests - setter method injection

    private Character enemy;
    @Setter // for tests - setter method injection
    private MenuChooser duelMenuChooser;
    @Getter // for tests
    private final int roundCounter = 0;
    @Setter // for tests
    private int range = 3;


    public Round(Character myHeroParameters, Character enemyParameters, int roundCounter) {
        this.myHero = myHeroParameters;
        this.enemy = enemyParameters;
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

    public void playRound() {
        heroStatsInDuel();
        enemyStatsInDuel();
        int userChoice = duelMenuChooser.userPick();
        switch (userChoice) {
            case 1 -> {
                myHeroAttack();
                enemyAttack();
            }
            case 2 -> {
                offensiveSkillsRound();
                enemyAttack();
            }
            case 3 -> {
                defensiveSkillsRound();
                enemyAttack();
            }
            case 4 -> {
                range = range - 1;
                enemyAttack();
            }
            case 5 -> {
                DefensiveRound defensiveRound = new DefensiveRound(myHero);
                defensiveRound.rest();
            }
        }
    }

    private void heroStatsInDuel() {
        System.out.println("My hero");
        System.out.println("HP: " + myHero.getDuelStats().getHp() + " MP: " + myHero.getDuelStats().getMp());

    }

    private void enemyStatsInDuel() {
        System.out.println("Enemy");
        System.out.println("HP: " + enemy.getDuelStats().getHp());
    }

    private void enemyAttack() {
        OffensiveRound offensiveRound = new OffensiveRound(myHero, enemy);
        if (enemyCanAttack()) {
            offensiveRound.enemyAttack();
        } else {
            System.out.println("I can't have to hit enemy. My attack range is too small");
            System.out.println("Step forward");
            range = range - 1;
        }
    }

    private boolean enemyCanAttack() {
        return enemy.getDuelStats().getAttackRange() >= range;
    }

    private void myHeroAttack() {
        if (!heroHaveAttackRange()) {
            System.out.println("You can't have to hit enemy. Your attack range is too small");
            playRound();
        }
        else {
            OffensiveRound offensiveRound = new OffensiveRound(myHero, enemy);
            offensiveRound.heroAttack();
        }
    }

    private boolean heroHaveAttackRange() {
        return range <= myHero.getDuelStats().getAttackRange();
    }

    private void offensiveSkillsRound() {
        if (myHeroCanUseOffensiveSkill()) {
            if (heroHaveAttackRange()) {

                OffensiveRound offensiveRound = new OffensiveRound(myHero, enemy);
                offensiveRound.offensiveSkills();
                enemyAttack();
            } else {
                System.out.println("You can't have to hit enemy. Your attack range is too small");
                playRound();
            }
        } else {
            System.out.println("Not enough mana points to use offensive skills");
            playRound();
        }
    }

    private void defensiveSkillsRound() {
        if (myHeroCanUseDefensiveSkill()) {
            DefensiveRound defensiveRound = new DefensiveRound(myHero);
            defensiveRound.defensiveSkills();
            enemyAttack();
        } else {
            System.out.println("Not enough mana points to use defensive skills");
            playRound();
        }
    }

    private boolean myHeroCanUseOffensiveSkill() {
        OffensiveRound offensiveRound = new OffensiveRound(myHero, enemy);
        return (offensiveRound.offensiveSkills() >= 0 && offensiveRound.offensiveSkills() < 9999);
    }

    private boolean myHeroCanUseDefensiveSkill() {
        DefensiveRound defensiveRound = new DefensiveRound(myHero);
        return (defensiveRound.defensiveSkills() >= 0 && defensiveRound.defensiveSkills() < 9999);
    }


}
