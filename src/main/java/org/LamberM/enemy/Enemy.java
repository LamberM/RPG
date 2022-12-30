package org.LamberM.enemy;


import org.LamberM.classes.MyClass;
import org.LamberM.game.Game;
import stats.Stats;

import java.util.Random;

public class Enemy{
    public Stats enemyStats = new Stats(20, 15, 10, 200, 0, 5, 200, 5,1);
    public void attack() {
        Game game = new Game();
        MyClass hero = new MyClass();
        int damage;
        System.out.println("org.LamberM.enemy.Enemy");
        if (enemyStats.getAttackRange()<=game.range) {
            Random draw = new Random();

            int heroChance=hero.stats.getCurrentDodge() + draw.nextInt(101);
            int enemyChance=enemyStats.getDexterity() + draw.nextInt(101);
            int critChance=enemyStats.getCurrentCritC() + draw.nextInt(101);

            if (enemyChance>heroChance) {
                damage = enemyStats.getStrength() + enemyStats.getDexterity() + enemyStats.getIntelligence() - (hero.stats.getCurrentArm() / 10);
                if (critChance < 100) {
                    System.out.println("Attack for " + damage);

                }
                else {
                    damage=damage*2;
                    System.out.println("Critical attack !!!! for " + damage + "!!!!");
                }
                int currHP=(hero.stats.getCurrentHP() - damage);
                hero.stats.setCurrentHP(currHP);
            }
            else {
                System.out.println("You missed");
            }
        }
        else { stepForward();}
    }
    public void lvlUP() {
        enemyStats.setStrength(enemyStats.getStrength()+5);
        enemyStats.setDexterity(enemyStats.getDexterity()+5);
        enemyStats.setIntelligence(enemyStats.getIntelligence()+5);
    }
    public void duelStats() {
        System.out.println("org.LamberM.enemy.Enemy:");
        enemyStats.duelStats();
    }

    public void stepForward() {
        Game game = new Game();
        game.range = game.range - 1;

    }

}
