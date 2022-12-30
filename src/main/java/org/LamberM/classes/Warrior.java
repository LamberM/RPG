package org.LamberM.classes;

import org.LamberM.enemy.Enemy;
import org.LamberM.stats.Stats;

public class Warrior extends Classes {
    public Warrior() {
        stats = new Stats(20, 15, 10, 200, 40, 5, 100, 5, 1);
    }

    @Override
    public void skills() {
        Enemy enemy = new Enemy();

        int heroChance = stats.getDexterity() + draw.nextInt(101);
        int enemyChance = enemy.enemyStats.getCurrentDodge() + draw.nextInt(101);
        int critChance = stats.getCurrentCritC() + draw.nextInt(101);

        System.out.println("1.Battle cry (20MP)");
        System.out.println("2.Defensive cry (20MP)");
        System.out.println("3.Double attack (20MP)");
        int userChoice = scanner.nextInt();
        if (userChoice > 0 && userChoice < 4) {
            switch (userChoice) {
                case 1 -> {
                        stats.setCurrentStr(stats.getCurrentStr() + 10);
                        stats.setCurrentDex(stats.getCurrentDex() + 5);
                        stats.setCurrentCritC(stats.getCurrentCritC() + 2);
                        stats.setCurrentMP(stats.getCurrentMP() - 20);
                        System.out.println("WAAAAAAAAAAAAAAAAAAAAAAAAAAARRRRRRRRRRR");

                }
                case 2 -> {
                        stats.setCurrentHP(stats.getCurrentHP() + 20);
                        stats.setCurrentArm(stats.getCurrentArm() + 10);
                        stats.setCurrentDodge(stats.getCurrentDodge() + 2);
                        stats.setCurrentMP(stats.getCurrentMP() - 20);
                        System.out.println("BAAAAAAAAAAAAAAAAAAAAAAAACCCCCKKKKKKKKKKKKKK");
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
                            enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage); // nie działa
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
