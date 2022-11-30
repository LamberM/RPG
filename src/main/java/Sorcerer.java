package main.java;

class Sorcerer extends Classes {
    Sorcerer() {
        stats = new Stats(5, 15, 25, 120, 80, 5, 40, 5, 2);
    }

    @Override
    public void skills() {
        Enemy enemy = new Enemy();

        int heroChance = stats.getDexterity() + draw.nextInt(101);
        int enemyChance = enemy.enemyStats.getCurrentDodge() + draw.nextInt(101);
        int critChance = stats.getCurrentCritC() + draw.nextInt(101);

        System.out.println("1.Kula Ognia (20MP)");
        System.out.println("2.Kula Mrozu (30MP)");
        System.out.println("3.Tarcza Mrozu (20MP)");
        int userChoice = scanner.nextInt();
        if (userChoice > 0 && userChoice < 4) {
            switch (userChoice) {
                case 1 -> {
                    if (stats.getCurrentMP() >= 20 && stats.getAttackRange() <= game.range) {
                        if (heroChance > enemyChance) {
                            damage = 30 + (stats.getIntelligence() / 5) - (enemy.enemyStats.getCurrentArm() / 20);
                            if (critChance < 100) {
                                enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage);
                                System.out.println("Uderzenie za " + damage);
                                stats.setCurrentMP(stats.getCurrentMP() - 25);
                            } else {
                                damage = 2 * damage;
                                enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage);
                                System.out.println("Uderzenie KRYTYCZNE !!!! za " + damage + "!!!!");
                                stats.setCurrentMP(stats.getCurrentMP() - 25);
                            }
                        } else {
                            System.out.println("Nie trafiłeś przeciwnika");
                        }

                    } else {
                        System.out.println("masz za mało MP lub za mały zasięg ataku");
                    }
                }
                case 2 -> {
                    if (stats.getCurrentMP() >= 30 && stats.getAttackRange() <= game.range) {

                        if (heroChance > enemyChance) {
                            damage = 35 + (stats.getIntelligence() / 5) - (enemy.enemyStats.getCurrentArm() / 20);
                            if (critChance < 100) {
                                enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage);
                                System.out.println("Uderzenie za " + damage);
                            } else {
                                damage = 2 * damage;
                                enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage);
                                System.out.println("Uderzenie KRYTYCZNE !!!! za " + damage + "!!!!");
                            }
                            enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage);
                            if (draw.nextInt(2) == 1) {
                                System.out.println("Zamroziłeś przeciwnika, stracił swoją kolejkę");
                            }
                        } else {
                            System.out.println("Nie trafiłeś przeciwnika");
                        }
                    } else {
                        System.out.println("masz za mało MP lub za mały zasięg ataku");
                    }
                }
                case 3 -> {
                    if (stats.getCurrentMP() >= 20) {
                        stats.setCurrentArm(stats.getCurrentArm() + 10);
                        stats.setCurrentMP(stats.getCurrentMP() - 20);
                        System.out.println(stats.getCurrentArm());
                        if (draw.nextInt(2) == 1) {
                            System.out.println("Zamroziłeś przeciwnika, stracił swoją kolejkę");
                        }
                    } else {
                        System.out.println("masz za mało MP");
                    }

                }
            }
        } else {
            System.out.println("Wpisałeś złą cyfre");
        }
    }

}
