package org.LamberM.classes;

import org.LamberM.enemy.EnemyTest;
import org.LamberM.stats.StatsTest;
import org.junit.jupiter.api.Test;

public class AssassinTest extends ClassesTest {
    public AssassinTest() {
        stats = new StatsTest(15, 20, 10, 150, 40, 10, 60, 10, 1);
    }
    @Test
    public void skills() {
        EnemyTest enemy = new EnemyTest();

        int heroChance = stats.getDexterity() + draw.nextInt(101);
        int enemyChance = enemy.enemyStats.getCurrentDodge() + draw.nextInt(101);
        int critChance = stats.getCurrentCritC() + draw.nextInt(101);

        System.out.println("1.Hit in the back (20MP)");
        System.out.println("2.Boost dodge and dexterity (20MP)");
        System.out.println("3.Critical attack (30MP)");
        int userChoice = 3;
        if (userChoice > 0 & userChoice < 4) {
            switch (userChoice) {
                case 1 -> {
                    if (stats.getAttackRange() <= game.range) {
                        if (heroChance > enemyChance) {
                            damage = 30 + (stats.getDexterity() / 5) - (enemy.enemyStats.getCurrentArm() / 20);
                            if (critChance < 100) {
                                System.out.println("Attack for " + damage);
                                stats.setCurrentMP(stats.getCurrentMP() - 20);
                            } else {
                                damage = 2 * damage;
                                System.out.println("Critical attack !!!! for " + damage + "!!!!");
                                stats.setCurrentMP(stats.getCurrentHP() - 20);
                            }
                            enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage);
                            // działa !!!
                        } else {
                            System.out.println("You missed");
                            // działa !!!
                        }

                    } else {
                        System.out.println("Your attack range is too small");
                    }
                }
                case 2 -> {
                    stats.setCurrentDex(stats.getCurrentDex() + 10);
                    stats.setCurrentDodge(stats.getCurrentDodge() + 5);
                    stats.setCurrentCritC(stats.getCurrentCritC()+5);
                    stats.setCurrentMP(stats.getCurrentMP() - 20);
                    System.out.println("I'm feeling agile like ninja");
                    // działa !!!
                }
                case 3 -> {
                    if (stats.getCurrentMP() >= 30 || stats.getAttackRange() <= game.range) {
                        if (heroChance > enemyChance) {
                            damage = 40 + (stats.getDexterity() / 5) - (enemy.enemyStats.getCurrentArm() / 20);
                            System.out.println("Attack for " + damage);
                            stats.setCurrentMP(stats.getCurrentMP() - 30);

                            enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage); // nie działa
                            // działą !!!
                        } else {
                            System.out.println("You missed");
                            // działa !!!
                        }
                    } else {
                        System.out.println("You don't have enough mana point or your attack range is too small");
                    }
                }
            }
        } else {
            System.out.println("You entered the wrong number. Try again");
        }
    }
}