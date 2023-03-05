package org.LamberM.enemy;


import org.LamberM.classes.MyClass;
import org.LamberM.game.Game;
import org.LamberM.stats.Stats;

import java.util.Random;

public class Enemy{
    public Enemy()
    {
        enemyStats = new Stats(20, 15, 10, 200, 0, 5, 200, 5,1);
        enemyDuelStats=enemyStats;
    }
    Game game = new Game();
    Stats enemyStats;
    public Stats enemyDuelStats;
    private MyClass hero = new MyClass();
    private int heroChance;
    private int enemyChance;
    private int critChance;

    private boolean enemyHaveAttackRange()
    {
        return enemyDuelStats.getAttackRange() >= game.getRange();
    }
    private void missOrAttackOrCrit()
    {
        Random draw = new Random();
        heroChance=hero.duelStats.getDodge() + draw.nextInt(101);
        enemyChance=enemyDuelStats.getDexterity()+ draw.nextInt(101);
        critChance=enemyDuelStats.getCriticalChance() + draw.nextInt(101);
    }
    private boolean enemyCanAttack()
    {
        return enemyChance>heroChance;
    }
    private boolean attackIsNotCritical()
    {
        return critChance < 100;
    }
    public void attack()
    {
        System.out.println("Enemy");
        if (enemyHaveAttackRange())
        {
            missOrAttackOrCrit();

            if (enemyCanAttack())
            {
                enemyDuelStats.setDamage( enemyDuelStats.getStrength() + enemyDuelStats.getDexterity() + enemyDuelStats.getIntelligence() - (hero.duelStats.getArmor() / 10));
                if (attackIsNotCritical())
                {
                    System.out.println("Attack for " + enemyDuelStats.getDamage());
                    hero.duelStats.setDuelHP(hero.duelStats.getHp() - enemyDuelStats.getDamage());
                }
                else
                {
                    enemyDuelStats.setDamage(enemyDuelStats.getDamage()* 2);
                    System.out.println("Critical attack !!!! for " + enemyDuelStats.getDamage() + "!!!!");
                    hero.duelStats.setDuelHP(hero.duelStats.getHp() - enemyDuelStats.getDamage());
                }
            }
            else
            {
                System.out.println("You missed");
            }
        }
        else
        {
            System.out.println("I can't have to hit enemy. My attack range is too small");
            stepForward();
        }
    }
//    public void lvlUP()
//    {
//        enemyStats.setStrength(enemyStats.getStrength()+5);
//        enemyStats.setDexterity(enemyStats.getDexterity()+5);
//        enemyStats.setIntelligence(enemyStats.getIntelligence()+5);
//    }
    public void duelStats()
    {
        System.out.println("Enemy:");
        enemyDuelStats.duelStats();
    }

    private void stepForward()
    {
        game.setRange(game.getRange()-1);
    }

}
