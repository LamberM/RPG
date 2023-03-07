package org.LamberM.characters;

import lombok.Getter;
import lombok.Setter;
import org.LamberM.game.Game;
import org.LamberM.stats.Stats;

import java.util.Scanner;

public class Assassin extends Characters {
    public Assassin()
    {
        stats = new Stats(15, 20, 10, 150, 40, 10, 60, 10, 1);
        duelStats = stats;
    }
    @Getter
    @Setter
    private int userChoice;
    private boolean userPickIsWrong()
    {
        return userChoice < 1 || userChoice > 4;
    }

    private void hitInTheBack()
    {
        Enemy enemy = new Enemy();
            if (heroCanAttack())
            {
                duelStats.setDuelMP((duelStats.getDuelMP() - 20));
                duelStats.setDamage( 30 + (duelStats.getDexterity() / 5) - (enemy.enemyDuelStats.getArmor() / 20));
                if (heroAttackIsNotCritical())
                {
                    System.out.println("Attack for " + duelStats.getDamage());
                    enemy.enemyDuelStats.setDuelHP(enemy.enemyDuelStats.getDuelHP() - duelStats.getDamage());
                }
                else
                {
                    duelStats.setDamage( 2 * duelStats.getDamage());
                    System.out.println("Critical attack !!!! for " + duelStats.getDamage() + "!!!!");
                    enemy.enemyDuelStats.setDuelHP(enemy.enemyDuelStats.getDuelHP() - duelStats.getDamage());
                }

            }
            else
            {
                System.out.println("You missed");
            }
    }
    private void boostDodgeAndDexterity()
    {
        duelStats.setDexterity(duelStats.getDexterity() + 10);
        duelStats.setDodge(duelStats.getDodge() + 5);
        duelStats.setCriticalChance(duelStats.getCriticalChance()+5);
        duelStats.setDuelMP(duelStats.getDuelMP() - 20);
        System.out.println("I'm feeling agile like ninja");
    }
    private boolean currentMpIsEnough()
    {
        Game game = new Game();
        return duelStats.getMp() >= 30;
    }
    private void criticalAttack()
    {
        Enemy enemy = new Enemy();
        if (currentMpIsEnough())
        {
            if (heroCanAttack())
            {
                duelStats.setDamage( 40 + (duelStats.getDexterity() / 5) - (enemy.enemyDuelStats.getArmor() / 20));
                System.out.println("Attack for " + duelStats.getDamage());
                duelStats.setDuelMP((duelStats.getDuelMP() - 30));

                enemy.enemyDuelStats.setDuelHP(enemy.enemyDuelStats.getDuelHP() - duelStats.getDamage());

            }
            else
            {
                System.out.println("You missed");
            }
        }
        else
        {
            System.out.println("You don't have enough mana point");
            skillsMenu();
        }
    }
    private void userPick()
    {
        Scanner scanner = new Scanner(System.in);
        userChoice = scanner.nextInt();
        if (userPickIsWrong())
        {
            System.out.println("You entered the wrong number. Try again");
            skillsMenu();
        }
        else
        {
            switch (userChoice)
            {
                case 1 -> hitInTheBack();
                case 2 -> boostDodgeAndDexterity();
                case 3 -> criticalAttack();
                case 4 -> System.out.println("Back to menu");
            }
        }
    }
    @Override
    public void skillsMenu()
    {
        missOrBaseOrCritAttack();

        System.out.println("1.Hit in the back (20MP)");
        System.out.println("2.Boost dodge and dexterity (20MP)");
        System.out.println("3.Critical attack (30MP)");
        System.out.println("4.Back to menu");
        userPick();
    }

}