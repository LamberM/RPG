package org.LamberM.game;

import lombok.Getter;
import org.LamberM.character.Character;
import org.LamberM.character.Enemy;
import org.LamberM.character.MyClass;

import java.util.Random;

public class Round {
    Duel duel = new Duel();
    @Getter
    private int critChance;
    @Getter
    private int heroChance;
    @Getter
    private int enemyChance;
    Character myHero;
    Character enemy = new Enemy();

    public void heroAttackOrCritOrMiss()
    {
        Random draw = new Random();
        heroChance= myHero.duelStats.getDexterity() + draw.nextInt(101);
        enemyChance=enemy.duelStats.getDodge() + draw.nextInt(101);
        critChance=myHero.duelStats.getCriticalChance() + draw.nextInt(101);
    }
    public void enemyAttackOrCritOrMiss()
    {
        Random draw = new Random();
        heroChance= myHero.duelStats.getDodge() + draw.nextInt(101);
        enemyChance=enemy.duelStats.getDexterity() + draw.nextInt(101);
        critChance=enemy.duelStats.getCriticalChance() + draw.nextInt(101);
    }
    private boolean enemyCanAttack()
    {
        return enemy.duelStats.getAttackRange() >= duel.getRange();
    }
    private boolean enemyMiss(){return heroChance >= enemyChance;}

    private boolean heroCanUseSkills() {
        return myHero.duelStats.getDuelMP() >= 20;
    }
    private boolean heroCanAttack() {
        return duel.getRange() <= myHero.duelStats.getAttackRange();
    }
    private boolean heroMiss(){return enemyChance >= heroChance;}

    private boolean attackIsCritical()
    {
        return critChance >= 100;
    }

    public void heroAttack()
    {
        if (heroCanAttack()) {
            heroAttackOrCritOrMiss();
            if (!heroMiss())
            {
                if (!attackIsCritical()) {
                    System.out.println("Attack for: "+ myHero.attack());
                    enemy.duelStats.setDuelHP(enemy.duelStats.getDuelHP()-(myHero.attack()-(enemy.duelStats.getArmor()/10)));
                }
                else {
                    int critical= 2*myHero.attack();
                    System.out.println("Critical attack for: "+ critical + "!!!!!!!!!!!!");
                    enemy.duelStats.setDuelHP(enemy.duelStats.getDuelHP()-(critical-(enemy.duelStats.getArmor()/10)));
                }
            }
            else {
                System.out.println("You missed");
            }
        }
        else {
                System.out.println("You can't have to hit enemy. Your attack range is too small");
            }
    }
    public void enemyAttack()
    {
        if (enemyCanAttack()) {
            enemyAttackOrCritOrMiss();
            if (!enemyMiss())
            {
                if (!attackIsCritical()) {
                    System.out.println("Attack for: "+ enemy.attack());
                    myHero.duelStats.setDuelHP(myHero.duelStats.getDuelHP()-(enemy.attack()-(myHero.duelStats.getArmor()/10)));
                }
                else {
                    int critical= 2*enemy.attack();
                    System.out.println("Critical attack for: "+ critical + "!!!!!!!!!!!!");
                    myHero.duelStats.setDuelHP(myHero.duelStats.getDuelHP()-(critical-(myHero.duelStats.getArmor()/10)));
                }
            }
            else {
                System.out.println("You missed");
            }
        }
        else {
            System.out.println("I can't have to hit enemy. My attack range is too small");
            System.out.println("Step forward");
            duel.setRange(duel.getRange()-1);
        }
    }

    public int offensiveSkills()
    {
        if (heroCanUseSkills()) {
            if (heroCanAttack()){
                heroAttackOrCritOrMiss();
                myHero.offensiveSkillsMenu();
                if (!heroMiss())
                {
                    if (!attackIsCritical()) {
                        System.out.println("Attack for: "+ myHero.offensiveSkillsMenu());
                        enemy.duelStats.setDuelHP(enemy.duelStats.getDuelHP()-(myHero.offensiveSkillsMenu()-(enemy.duelStats.getArmor()/10)));
                        return myHero.offensiveSkillsMenu();
                    }
                    else {
                        int critical= myHero.offensiveSkillsMenu()*2;
                        System.out.println("Critical attack for: "+ critical + "!!!!!!!!!!!!");
                        enemy.duelStats.setDuelHP(enemy.duelStats.getDuelHP()-(critical-(enemy.duelStats.getArmor()/10)));
                        return critical;
                    }
                }
                else {
                    System.out.println("You missed");
                }
            }
            else {
                System.out.println("You don't have enough attack range");
                return 9999;
            }
        } else {
            System.out.println("You don't have enough mana points");
            return 9999;
        }
        return 0;
    }
    public int defensiveSkills()
    {
        if (heroCanUseSkills()) {
            myHero.defensiveSkillsMenu();
            return 0;
        } else {
            System.out.println("You don't have enough mana points");
            return 9999;
        }
    }

    public void rest()
    {
        myHero.rest();
        enemyAttack();
    }
}
