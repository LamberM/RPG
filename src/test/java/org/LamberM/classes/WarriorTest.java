package org.LamberM.classes;


import org.LamberM.enemy.EnemyTest;
import org.LamberM.stats.StatsTest;
import org.junit.jupiter.api.Test;


public class WarriorTest extends ClassesTest {
    public WarriorTest() {
        stats = new StatsTest(20, 15, 10, 200, 40, 5, 100, 5, 1);
    }

    @Test
    public void skills() {
        EnemyTest enemy = new EnemyTest();

        int heroChance = stats.getDexterity() + draw.nextInt(101);
        int enemyChance = enemy.enemyStats.getCurrentDodge() + draw.nextInt(101);
        int critChance = stats.getCurrentCritC() + draw.nextInt(101);

        System.out.println("1.Battle cry (20MP)");
        System.out.println("2.Defensive cry (20MP)");
        System.out.println("3.Double attack (20MP)");
        int userChoice = 1;
        if (userChoice > 0 && userChoice < 4) {
            switch (userChoice) {
                case 1 -> {
                    showStats();
                    stats.setCurrentStr(stats.getCurrentStr() + 10);
                    stats.setCurrentDex(stats.getCurrentDex() + 5);
                    stats.setCurrentCritC(stats.getCurrentCritC() + 2);
                    stats.setCurrentMP(stats.getCurrentMP() - 20);
                    System.out.println("WAAAAAAAAAAAAAAAAAAAAAAAAAAARRRRRRRRRRR");
                    showStats();
                }
                case 2 -> {
                    showStats();
                    stats.setCurrentHP(stats.getCurrentHP() + 20);
                    stats.setCurrentArm(stats.getCurrentArm() + 10);
                    stats.setCurrentDodge(stats.getCurrentDodge() + 2);
                    stats.setCurrentMP(stats.getCurrentMP() - 20);
                    System.out.println("BAAAAAAAAAAAAAAAAAAAAAAAACCCCCKKKKKKKKKKKKKK");
                    showStats();
                }
                case 3 -> {
                    if (stats.getAttackRange() <= game.range) {
                        if (heroChance > enemyChance) {
                            damage = 60 + (stats.getStrength() / 5) - (enemy.enemyStats.getCurrentArm() / 20);
                            if (critChance < 100) {
                                System.out.println("Attack for " + damage);
                                stats.setCurrentMP(stats.getCurrentMP() - 20);
                            } else {
                                damage = 2 * damage;
                                System.out.println("Critical attack !!!! for " + damage + "!!!!");
                                stats.setCurrentMP(stats.getCurrentMP() - 20);
                            }
                            enemy.duelStats();
                            enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage);
                            enemy.duelStats();

                        } else {
                            System.out.println("You missed");
                        }

                    } else {
                        System.out.println("Your attack range is too small");

                    }
                }
            }
        } else {
            System.out.println("You entered the wrong number. Try again");
        }

    }
}