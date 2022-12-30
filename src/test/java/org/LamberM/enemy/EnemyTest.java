package org.LamberM.enemy;

import org.LamberM.classes.MyClassTest;
import org.LamberM.game.GameTest;
import org.LamberM.stats.StatsTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {
    public StatsTest enemyStats = new StatsTest(20, 15, 10, 200, 0, 5, 200, 5,1);
    @Test
    public void attack() {
        GameTest game = new GameTest();
        MyClassTest hero = new MyClassTest();
        int damage;
        System.out.println("Enemy");
        if (enemyStats.getAttackRange()<=game.range) {
            Random draw = new Random();

            int heroChance=hero.stats.getCurrentDodge() + draw.nextInt(101);
            int enemyChance=enemyStats.getDexterity() + draw.nextInt(101);
            int critChance=enemyStats.getCurrentCritC() + draw.nextInt(101);
            hero.duelStats();
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
                hero.duelStats();
            }
            else {
                System.out.println("You missed");
            }
        }
        else { stepForward();}
    }
    @Test
    public void lvlUP() {
        enemyStats.setStrength(enemyStats.getStrength()+5);
        enemyStats.setDexterity(enemyStats.getDexterity()+5);
        enemyStats.setIntelligence(enemyStats.getIntelligence()+5);
    }
    @Test
    public void duelStats() {
        System.out.println("Enemy:");
        enemyStats.duelStats();
    }
    @Test
    public void stepForward() {
        GameTest game = new GameTest();
        game.range = game.range - 1;

    }
}