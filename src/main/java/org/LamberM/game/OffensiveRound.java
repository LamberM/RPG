package org.LamberM.game;


import lombok.Setter;
import org.LamberM.character.Character;

import java.util.Random;

public class OffensiveRound {
    @Setter // for tests - setter method injection

    private Character myHero;
    @Setter // for tests - setter method injection

    private Character enemy;

    public OffensiveRound(Character myHeroParameters, Character enemyParameters) {
        this.myHero = myHeroParameters;
        this.enemy = enemyParameters;
    }

    private int critChance;
    private int heroChance;
    private int enemyChance;

    public void heroAttack() {
        heroAttackOrCritOrMiss();
        if (heroMiss()) {
            System.out.println("You missed");
        } else {
            if (criticalAttack()) {
                int critical = 2 * myHero.attack();
                System.out.println("Critical attack for: " + critical + "!!!!!!!!!!!!");
                enemy.getDuelStats().setHp(enemy.getDuelStats().getHp() - (critical - (enemy.getDuelStats().getArmor() / 10)));
            } else {
                System.out.println("Attack for: " + myHero.attack());
                enemy.getDuelStats().setHp(enemy.getDuelStats().getHp() - (myHero.attack() - (enemy.getDuelStats().getArmor() / 10)));
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
                myHero.getDuelStats().setHp(myHero.getDuelStats().getHp() - (critical - (myHero.getDuelStats().getArmor() / 10)));
            } else {
                System.out.println("Attack for: " + enemy.attack());
                myHero.getDuelStats().setHp(myHero.getDuelStats().getHp() - (enemy.attack() - (myHero.getDuelStats().getArmor() / 10)));
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
                int critical = (myHero.offensiveSkillsMenu() * 2)- (enemy.getDuelStats().getArmor() / 10);
                System.out.println("Critical attack for: " + critical + "!!!!!!!!!!!!");
                enemy.getDuelStats().setHp(enemy.getDuelStats().getHp() - critical);
                return critical;
            } else {
                int damage = myHero.offensiveSkillsMenu()- (enemy.getDuelStats().getArmor() / 10);
                System.out.println("Attack for: " + damage);
                enemy.getDuelStats().setHp(enemy.getDuelStats().getHp() - damage);
                return damage;
            }
        }
    }

    private void heroAttackOrCritOrMiss() {
        Random draw = new Random();
        heroChance = myHero.getDuelStats().getDexterity() + draw.nextInt(101);
        enemyChance = enemy.getDuelStats().getDodge() + draw.nextInt(101);
        critChance = myHero.getDuelStats().getCriticalChance() + draw.nextInt(101);
    }

    private void enemyAttackOrCritOrMiss() {
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
