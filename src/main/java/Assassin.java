package main.java;

class Assassin extends Classes {
    Assassin() {
        stats = new Stats(15, 20, 10, 150, 40, 10, 60, 10, 1);
    }

    @Override
    public void skills() {
        Enemy enemy = new Enemy();

        int heroChance = stats.getDexterity() + draw.nextInt(101);
        int enemyChance = enemy.enemyStats.getCurrentDodge() + draw.nextInt(101);
        int critChance = stats.getCurrentCritC() + draw.nextInt(101);

        System.out.println("1.Cios w plecy (20MP)");
        System.out.println("2.Zwiększenie uniku i zręczności (20MP)");
        System.out.println("3.Atak krytyczny (30MP)");
        int userChoice = scanner.nextInt();
        if (userChoice > 0 & userChoice < 4) {
            switch (userChoice) {
                case 1 -> {
                    if (stats.getCurrentMP() >= 20 && stats.getAttackRange() <= game.range) {
                        if (heroChance > enemyChance) {
                            damage = 30 + (stats.getDexterity() / 5) - (enemy.enemyStats.getCurrentArm() / 20);
                            if (critChance < 100) {
                                System.out.println("Uderzenie za " + damage);
                                stats.setCurrentMP(stats.getCurrentMP() - 20);
                            } else {
                                damage = 2 * damage;
                                System.out.println("Uderzenie KRYTYCZNE !!!! za " + damage + "!!!!");
                                stats.setCurrentMP(stats.getCurrentHP() - 20);
                            }
                            enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage);

                        } else {
                            System.out.println("Nie trafiłeś przeciwnika");
                        }

                    } else {
                        System.out.println("masz za mało MP lub za mały zasięg ataku");
                    }
                }
                case 2 -> {
                    if (stats.getCurrentMP() >= 20) {
                        stats.setCurrentDex(stats.getCurrentDex() + 10);
                        stats.setCurrentDodge(stats.getCurrentDodge() + 5);
                        stats.setCurrentMP(stats.getCurrentMP() - 20);
                        System.out.println("Czuje się zwinny jak ninja");
                    } else {
                        System.out.println("masz za mało MP");
                    }
                }
                case 3 -> {
                    if (stats.getCurrentMP() >= 30 && stats.getAttackRange() <= game.range) {
                        if (heroChance > enemyChance) {
                            damage = 40 + (stats.getDexterity() / 5) - (enemy.enemyStats.getCurrentArm() / 20);
                            System.out.println("Uderzenie za " + damage);
                            stats.setCurrentMP(stats.getCurrentMP() - 30);

                            enemy.enemyStats.setCurrentHP(enemy.enemyStats.getCurrentHP() - damage); // nie działa

                        } else {
                            System.out.println("Nie trafiłeś przeciwnika");
                        }
                    } else {
                        System.out.println("masz za mało MP lub za mały zasięg ataku");
                    }
                }
            }
        } else {
            System.out.println("Wpisałeś złą cyfre");
        }
    }
}
