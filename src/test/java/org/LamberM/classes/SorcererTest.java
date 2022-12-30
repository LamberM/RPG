package org.LamberM.classes;


import org.LamberM.enemy.EnemyTest;
import org.LamberM.stats.StatsTest;
import org.junit.jupiter.api.Test;


public class SorcererTest extends ClassesTest {
    public SorcererTest() {
        stats = new StatsTest(5, 15, 25, 120, 80, 5, 40, 5, 2);
    }

    @Test
    public void skills() {
        EnemyTest enemy = new EnemyTest();

        int heroChance = stats.getDexterity() + draw.nextInt(101);
        int enemyChance = enemy.enemyStats.getCurrentDodge() + draw.nextInt(101);
        int critChance = stats.getCurrentCritC() + draw.nextInt(101);

        System.out.println("1.Fire ball (20MP)");
        System.out.println("2.Snow ball (30MP)");
        System.out.println("3.Frost armor (20MP)");
        int userChoice = 2;
        enemy.duelStats();
        if (userChoice > 0 && userChoice < 4) {
            switch (userChoice) {
                case 1 -> {
                    if (stats.getAttackRange() <= game.range) {
                        if (heroChance > enemyChance) {
                            damage = 30 + (stats.getIntelligence() / 5) - (enemy.enemyStats.getCurrentArm() / 20);
                            if (critChance < 100) {
                                enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage);
                                System.out.println("Attack for " + damage);
                                stats.setCurrentMP(stats.getCurrentMP() - 25);
                            } else {
                                damage = 2 * damage;
                                enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage);
                                System.out.println("Critical attack !!!! for " + damage + "!!!!");
                                stats.setCurrentMP(stats.getCurrentMP() - 25);
                            }
                            enemy.duelStats();
                        } else {
                            System.out.println("You missed");
                        }

                    } else {
                        System.out.println("Your attack range is too small");
                    }
                }
                case 2 -> {
                    if (stats.getCurrentMP() >= 30 && stats.getAttackRange() <= game.range) {

                        if (heroChance > enemyChance) {
                            damage = 35 + (stats.getIntelligence() / 5) - (enemy.enemyStats.getCurrentArm() / 20);
                            if (critChance < 100) {
                                enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage);
                                System.out.println("Attack for " + damage);
                            } else {
                                damage = 2 * damage;
                                enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage);
                                System.out.println("Critical attack !!!! for " + damage + "!!!!");
                            }
                            enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage);
                            if (draw.nextInt(9) == 1) {
                                System.out.println("You froze enemy, he lost his turn");
                            }
                        } else {
                            System.out.println("You missed");
                        }
                    } else {
                        System.out.println("You don't have enough mana point or your attack range is too small");
                    }
                }
                case 3 -> {
                    showStats();
                    stats.setCurrentArm(stats.getCurrentArm() + 10);
                    stats.setCurrentMP(stats.getCurrentMP() - 20);
                    System.out.println(stats.getCurrentArm());
                    if (draw.nextInt(2) == 1) {
                        System.out.println("You froze enemy, he lost his turn");
                    }
                    showStats();
                }
            }
        } else {
            System.out.println("You entered the wrong number. Try again");
        }
    }

}