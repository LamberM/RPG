package main.java;

class Warrior extends Classes {
    Warrior() {
        stats = new Stats(20, 15, 10, 200, 40, 5, 100, 5, 1);
    }

    @Override
    public void skills() {
        Enemy enemy = new Enemy();

        int heroChance = stats.getDexterity() + draw.nextInt(101);
        int enemyChance = enemy.enemyStats.getCurrentDodge() + draw.nextInt(101);
        int critChance = stats.getCurrentCritC() + draw.nextInt(101);

        System.out.println("1.Okrzyk bojowy (20MP)");
        System.out.println("2.Okrzyk obronny (20MP)");
        System.out.println("3.Podwójny atak (20MP)");
        int userChoice = scanner.nextInt();
        if (userChoice > 0 && userChoice < 4) {
            switch (userChoice) {
                case 1 -> {
                    if (stats.getCurrentMP() >= 20) {
                        stats.setCurrentStr(stats.getCurrentStr() + 10);
                        stats.setCurrentDex(stats.getCurrentDex() + 5);
                        stats.setCurrentCritC(stats.getCurrentCritC() + 2);
                        stats.setCurrentMP(stats.getCurrentMP() - 10);
                        System.out.println("WAAAAAAAAAAAAAAAAAAAAAAAAAAARRRRRRRRRRR");
                    } else {
                        System.out.println("masz za mało MP");
                    }
                }
                case 2 -> {
                    if (stats.getCurrentMP() >= 20) {
                        stats.setCurrentHP(stats.getCurrentHP() + 20);
                        stats.setCurrentArm(stats.getCurrentArm() + 10);
                        stats.setCurrentDodge(stats.getCurrentDodge() + 2);
                        stats.setCurrentMP(stats.getCurrentMP() - 10);
                        System.out.println("BAAAAAAAAAAAAAAAAAAAAAAAACCCCCKKKKKKKKKKKKKK");

                    } else {
                        System.out.println("masz za mało MP");
                    }
                }
                case 3 -> {
                    if (stats.getCurrentMP() >= 20 && stats.getAttackRange() <= game.range) {
                        if (heroChance > enemyChance) {
                            damage = 60 + (stats.getStrength() / 5) - (enemy.enemyStats.getCurrentArm() / 20);
                            if (critChance < 100) {
                                System.out.println("Uderzenie za " + damage);
                                stats.setCurrentMP(stats.getCurrentMP() - 10);
                            } else {
                                damage = 2 * damage;
                                System.out.println("Uderzenie KRYTYCZNE !!!! za " + damage + "!!!!");
                                stats.setCurrentMP(stats.getCurrentMP() - 10);
                            }
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
