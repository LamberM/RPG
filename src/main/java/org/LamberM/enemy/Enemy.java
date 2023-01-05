package org.LamberM.enemy;


import org.LamberM.classes.MyClass;
import org.LamberM.game.Game;
import stats.HeroStats;
import stats.Stats;

import java.util.Random;

public class Enemy{
    public Stats enemyStats = new Stats(20, 15, 10, 200, 0, 5, 200, 5,1);
    public HeroStats enemyDuelStats= new HeroStats();
    private MyClass hero = new MyClass();
    private int heroChance;
    private int enemyChance;
    private int critChance;

    private boolean enemyAttackRangeIsMoreOrEqualsGameRange()
    {
        Game game = new Game();
        return enemyDuelStats.getAttackRange()<=game.range;
    }
    private void chanceForAttackOrCriticalAttack(){
        Random draw = new Random();
        heroChance=hero.heroStats.getCurrentDodge() + draw.nextInt(101);
        enemyChance=enemyDuelStats.getCurrentDex()+ draw.nextInt(101);
        critChance=enemyDuelStats.getCurrentCritC() + draw.nextInt(101);
    }
    private boolean enemyAttackChanceIsMoreThanHeroDodgeChance()
    {
        return enemyChance>heroChance;
    }
    private boolean attackIsNotCritical()
    {
        return critChance < 100;
    }
    public void attack()
    {
        int damage;
        System.out.println("Enemy");
        if (enemyAttackRangeIsMoreOrEqualsGameRange())
        {

            chanceForAttackOrCriticalAttack();

            if (enemyAttackChanceIsMoreThanHeroDodgeChance())
            {
                damage = enemyDuelStats.getCurrentStr() + enemyDuelStats.getCurrentDex() + enemyDuelStats.getCurrentInt() - (hero.heroStats.getCurrentArm() / 10);

                if (attackIsNotCritical())
                {
                    System.out.println("Attack for " + damage);
                }
                else
                {
                    damage=damage*2;
                    System.out.println("Critical attack !!!! for " + damage + "!!!!");
                }

                hero.heroStats.setCurrentHP(hero.heroStats.getCurrentHP() - damage);
            }
            else
            {
                System.out.println("You missed");
            }
        }
        else
        {
            stepForward();
        }
    }
    public void lvlUP()
    {
        enemyStats.setStrength(enemyStats.getStrength()+5);
        enemyStats.setDexterity(enemyStats.getDexterity()+5);
        enemyStats.setIntelligence(enemyStats.getIntelligence()+5);
    }
    public void duelStats()
    {
        HeroStats enemyDuelStats= new HeroStats();
        System.out.println("Enemy:");
        enemyDuelStats.duelStats();
    }

    private void stepForward()
    {
        Game game = new Game();
        game.range = game.range - 1;
    }

}
