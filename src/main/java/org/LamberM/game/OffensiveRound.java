package org.LamberM.game;

import lombok.Getter;
import org.LamberM.character.Character;

import java.util.Random;

public class OffensiveRound {
    private final Character myHero;
    private final Character enemy;

    public OffensiveRound(Character myHeroParameters, Character enemyParameters) {
        this.myHero = myHeroParameters;
        this.enemy = enemyParameters;
    }

    @Getter
    private int critChance;
    @Getter
    private int heroChance;
    @Getter
    private int enemyChance;

    public void heroAttack() {
        heroAttackOrCritOrMiss();
        if (heroMiss()) {
            System.out.println("You missed");
        } else {
            if (criticalAttack()) {
                int critical = 2 * myHero.attack();
                System.out.println("Critical attack for: " + critical + "!!!!!!!!!!!!");
                enemy.getDuelStats().setDuelHP(enemy.getDuelStats().getDuelHP() - (critical - (enemy.getDuelStats().getArmor() / 10)));
            } else {
                System.out.println("Attack for: " + myHero.attack());
                enemy.getDuelStats().setDuelHP(enemy.getDuelStats().getDuelHP() - (myHero.attack() - (enemy.getDuelStats().getArmor() / 10)));
            }
        }
    }


    public void enemyAttack() {
        enemyAttackOrCritOrMiss();
        if (enemyMiss()) {
            System.out.println("You missed");
        } else {
            if (criticalAttack()) {
                int critical = 2 * enemy.attack();
                System.out.println("Critical attack for: " + critical + "!!!!!!!!!!!!");
                myHero.getDuelStats().setDuelHP(myHero.getDuelStats().getDuelHP() - (critical - (myHero.getDuelStats().getArmor() / 10)));
            } else {
                System.out.println("Attack for: " + enemy.attack());
                myHero.getDuelStats().setDuelHP(myHero.getDuelStats().getDuelHP() - (enemy.attack() - (myHero.getDuelStats().getArmor() / 10)));
            }
        }

    }

    public int offensiveSkills() {
        heroAttackOrCritOrMiss();
        myHero.offensiveSkillsMenu();
        if (heroMiss()) {
            System.out.println("You missed");
            return 0;
        } else {
            if (criticalAttack()) {
                int critical = myHero.offensiveSkillsMenu() * 2;
                System.out.println("Critical attack for: " + critical + "!!!!!!!!!!!!");
                enemy.getDuelStats().setDuelHP(enemy.getDuelStats().getDuelHP() - (critical - (enemy.getDuelStats().getArmor() / 10)));
                return critical;
            } else {
                System.out.println("Attack for: " + myHero.offensiveSkillsMenu());
                enemy.getDuelStats().setDuelHP(enemy.getDuelStats().getDuelHP() - (myHero.offensiveSkillsMenu() - (enemy.getDuelStats().getArmor() / 10)));
                return myHero.offensiveSkillsMenu();
            }
        }
    }

    public void heroAttackOrCritOrMiss() {
        Random draw = new Random();
        heroChance = myHero.getDuelStats().getDexterity() + draw.nextInt(101);
        enemyChance = enemy.getDuelStats().getDodge() + draw.nextInt(101);
        critChance = myHero.getDuelStats().getCriticalChance() + draw.nextInt(101);
    }

    public void enemyAttackOrCritOrMiss() {
        Random draw = new Random();
        heroChance = myHero.getDuelStats().getDodge() + draw.nextInt(101);
        enemyChance = enemy.getDuelStats().getDexterity() + draw.nextInt(101);
        critChance = enemy.getDuelStats().getCriticalChance() + draw.nextInt(101);
    }

    private boolean enemyMiss() {
        return heroChance >= enemyChance;
    }

    private boolean heroMiss() {
        return enemyChance >= heroChance;
    }

    private boolean criticalAttack() {
        return critChance >= 100;
    }
}
