package main.java;

import java.util.Random;
import java.util.Scanner;

abstract class Classes{
    Stats stats= new Stats(1,1,1,1,1,1,1,1,1);
    Scanner scanner = new Scanner(System.in);
    Game game= new Game();
    Random draw = new Random();
    int damage;
    public void showStats() {
        stats.showStats();
    }
    public void duelStats() {
        System.out.println("My hero");
        stats.duelStats();
    }
    public void lvlUP() {
        stats.addStats();
    }
    public void rest() {
        stats.setCurrentHP(stats.getCurrentHP() + 20);
        stats.setCurrentMP(stats.getCurrentMP() + 20);
        if (stats.getCurrentHP() > stats.getHP() || stats.getCurrentHP() > stats.getMP())
        {
            stats.setCurrentHP(stats.getHP());
            stats.setCurrentMP(stats.getMP());
        }
    }
    public void attack() {
        Enemy enemy= new Enemy();

        int heroChance=stats.getDexterity() + draw.nextInt(101);
        int enemyChance=enemy.enemyStats.getCurrentDodge() + draw.nextInt(101);
        int critChance=stats.getCurrentCritC() + draw.nextInt(101);

        System.out.println("1.Attack");
        System.out.println("2.Strong Attack");
        int userChoice = scanner.nextInt();
        if (userChoice > 0 && userChoice < 3) {
            switch (userChoice) {
                case 1 -> {
                    System.out.println("My hero: ");
                    if (heroChance > enemyChance) {
                        damage = ((stats.getStrength()+ (stats.getDexterity())) - (enemy.enemyStats.getCurrentArm() / 20));
                        if (critChance> 100) {
                            System.out.println("Critical attack !!!! for " + damage + "!!!!");
                        } else {
                            damage = 2 * damage;
                            System.out.println("Attack for " + damage);
                        }
                        int currHP=(enemy.enemyStats.getCurrentHP() - damage);
                        enemy.enemyStats.setCurrentHP(currHP);
                    }
                    else {
                        System.out.println("You missed");
                    }
                }
                case 2 -> {
                    if (heroChance > enemyChance) {
                        damage = 2*((stats.getStrength()+ (stats.getDexterity())) - (enemy.enemyStats.getCurrentArm() / 20));
                        if (critChance > 100) {
                            System.out.println("Critical attack !!!! for " + damage + "!!!!");
                        } else {
                            damage = 2 * damage;
                            System.out.println("Attack for " + damage);
                        }
                        int currHP=(enemy.enemyStats.getCurrentHP() - damage);
                        enemy.enemyStats.setCurrentHP(currHP);
                    }
                    else {
                        System.out.println("You missed");
                    }
                }
            }
        }
        else {
            System.out.println("You entered the wrong number. Try again");
        }
    }
    public void skills(){}
}
