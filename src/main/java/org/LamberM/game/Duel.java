package org.LamberM.game;

import lombok.Getter;
import lombok.Setter;
import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;
import java.util.Random;

public class Duel {
    public Duel() {
        duelMenu();
    }
    MenuChooser duelMenuChooser= new MenuChooser(new SystemInReader(),
            List.of(
                    "1.Attack",
                    "2.Skills",
                    "3.Step forward",
                    "4.Rest"
            )
    );
    Journey journey = new Journey();

    //////////////////// Attack function ///////////////////////////////////////
    @Getter
    @Setter
    private int damage;
    private int duelRange = 3;
    private int critChance;

//////////////////////// Hero function /////////////////////////////////////////
    private void heroShowDuelHpMp() {
        System.out.println("My hero");
        System.out.println("HP: " + journey.hero.myHero.duelStats.getDuelHP() + " MP: " + journey.hero.myHero.duelStats.getDuelMP());
    }

    private boolean heroCanUseSkills() {
        return journey.hero.myHero.duelStats.getDuelMP() >= 20;
    }

    private boolean heroCanAttack() {
        return duelRange <= journey.hero.myHero.duelStats.getAttackRange();
    }

    //////////////////////// Enemy function /////////////////////////////////////////
    void missOrBaseOrCritAttack()
    {
        Random draw = new Random();
        int heroChance;
        int enemyChance;
        heroChance= duelStats.getDexterity() + draw.nextInt(101);
        enemyChance=enemyDuelStats.getDodge() + draw.nextInt(101);
        critChance=enemyDuelStats.getCriticalChance() + draw.nextInt(101);
    }
    private void enemyShowDuelHpMp() {
        System.out.println("Enemy");
        System.out.println("HP: " + enemyDuelStats.getDuelHP() + " MP: " + enemyDuelStats.getDuelMP());
    }
    private boolean enemyCanAttack()
    {
        return enemyDuelStats.getAttackRange() >= duelRange;
    }
    private boolean enemyAttackIsNotCritical()
    {
        return critChance < 100;
    }
    public void enemyAttack()
    {
        missOrBaseOrCritAttack();
        damage= enemyDuelStats.getStrength() + enemyDuelStats.getDexterity() + enemyDuelStats.getIntelligence() - (journey.hero.myHero.duelStats.getArmor() / 10);
        if (enemyAttackIsNotCritical())
        {
            System.out.println("Attack for " + damage);
            journey.hero.myHero.duelStats.setDuelHP(journey.hero.myHero.duelStats.getHp() - damage);
        }
        else
        {
            damage = damage* 2;
            System.out.println("Critical attack !!!! for " + damage + "!!!!");
            journey.hero.myHero.duelStats.setDuelHP(journey.hero.myHero.duelStats.getHp() - damage);
        }
        System.out.println("You missed");
    }
//    public void lvlUP()
//    {
//        enemyStats.setStrength(enemyStats.getStrength()+5);
//        enemyStats.setDexterity(enemyStats.getDexterity()+5);
//        enemyStats.setIntelligence(enemyStats.getIntelligence()+5);
//    }
    ///////////////////////////// Duel /////////////////////////////////////////

    public void duelMenu() {
        heroShowDuelHpMp();
        enemyShowDuelHpMp();
        int userChoice = duelMenuChooser.userPick();

        switch (userChoice) {
            case 1 -> {

                if (heroCanAttack()) {
                    journey.hero.myHero.attackMenu();
                        if (enemyCanAttack()) {
                            enemyAttack();
                        }
                        else {
                            duelRange= duelRange-1;
                            userChoice = duelMenuChooser.userPick();
                        }
                } else {
                    System.out.println("You can't have to hit enemy. Your attack range is too small");
                    userChoice=duelMenuChooser.userPick();
                }
            }
            case 2 -> {
                if (heroCanUseSkills()) {
                    journey.hero.myHero.skillsMenu();
                    if (enemyCanAttack()) {
                        enemyAttack();
                    }
                    else {
                        duelRange= duelRange-1;
                        userChoice = duelMenuChooser.userPick();
                    }
                } else {
                    System.out.println("You don't have enough mana points");
                    userChoice=duelMenuChooser.userPick();
                }
            }
            case 3 -> {
                duelRange = duelRange - 1;
                if (enemyCanAttack()) {
                    enemyAttack();
                }
                else {
                    duelRange= duelRange-1;
                    userChoice = duelMenuChooser.userPick();
                }
            }
            case 4 -> {
                journey.hero.myHero.rest();
                if (enemyCanAttack()) {
                    enemyAttack();
                }
                else {
                    duelRange= duelRange-1;
                    userChoice = duelMenuChooser.userPick();
                }
            }
        }
    }



}
