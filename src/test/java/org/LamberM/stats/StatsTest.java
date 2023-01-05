package org.LamberM.stats;

import lombok.Getter;
import lombok.Setter;
import org.LamberM.game.GameTest;
import java.util.Scanner;
@Getter
@Setter
public class StatsTest {
    private int EXP = 0;
    private int LVL = 1;
    private int LVLtocompare = 2;
    private int Strength, Dexterity, Intelligence, HP, MP, Dodge, Armor, CriticalChance, AttackRange, CurrentHP, CurrentMP, CurrentArm, CurrentStr, CurrentDex, CurrentCritC, CurrentDodge;

    public StatsTest(int strength, int dexterity, int intelligence, int HP, int MP, int dodge, int armor, int criticalChance, int attackRange) {
        this.Strength = strength;
        this.Dexterity = dexterity;
        this.Intelligence = intelligence;
        this.HP = HP;
        this.MP = MP;
        this.Dodge = dodge;
        this.Armor = armor;
        this.CriticalChance = criticalChance;
        this.AttackRange = attackRange;
        //current stats whose need to duel
        this.CurrentStr = this.Strength;
        this.CurrentDex = this.Dexterity;
        this.CurrentHP = this.HP;
        this.CurrentMP = this.MP;
        this.CurrentDodge = this.Dodge;
        this.CurrentArm = this.Armor;
        this.CurrentCritC = this.CriticalChance;
    }

    public void showStats() {
        System.out.println("Strength: " + this.CurrentStr);
        System.out.println("Dexterity: " + this.CurrentDex);
        System.out.println("Intelligence: " + this.Intelligence);
        System.out.println("HP: " + this.CurrentHP);
        System.out.println("MP: " + this.CurrentMP);
        System.out.println("Dodge: " + this.CurrentDodge);
        System.out.println("Armor: " + this.CurrentArm);
        System.out.println("Critical attack chance: " + this.CurrentCritC);
    }

    // add stats after lvl up
    public void addStats() {
        Scanner scanner = new Scanner(System.in);
        GameTest game = new GameTest();
        double actuallypoints = 0;
        if (getLVL() == getLVLtocompare()) {
            actuallypoints = 10;
            System.out.println("Your experience points "+ actuallypoints);
            System.out.println("Your stats for change:");
            System.out.println("Strength:" + getStrength());
            System.out.println("Dexterity:" + getDexterity());
            System.out.println("Intelligence:" + getIntelligence());
            System.out.println("Add stats points");
            System.out.println("1.Strength");
            System.out.println("2.Dexterity");
            System.out.println("3.Intelligence");
            System.out.println("4.Back to the menu");
            int userChoice = scanner.nextInt();
            if (userChoice > 0 && userChoice < 5) {
                switch (userChoice) {
                    case 1 -> {
                        setStrength(this.Strength + 5);
                        System.out.println("Strength: " + getStrength());
                        actuallypoints = actuallypoints - 5;
                        if (actuallypoints == 0) {
                            System.out.println("You don't have enough points");
                            game.mainMENU();
                        }
                    }
                    case 2 -> {
                        setDexterity(this.Dexterity + 5);
                        System.out.println("Dexterity: " + getDexterity());
                        actuallypoints = actuallypoints - 5;
                        if (actuallypoints == 0) {
                            System.out.println("You don't have enough points");
                            game.mainMENU();
                        }
                    }
                    case 3 -> {
                        setIntelligence(this.Intelligence + 5);
                        System.out.println("Intelligence:" + getIntelligence());
                        actuallypoints = actuallypoints - 5;
                        if (actuallypoints == 0) {
                            System.out.println("You don't have enough points");
                            game.mainMENU();
                        }
                    }
                    case 4 -> {
                    }
                }
            } else {
                addStats();
                System.out.println("You entered the wrong number. Try again");
            }
        } else {
            System.out.println("You need " + (100 - getEXP()) + " experience points to next level");
        }
    }
    // dualstats need in duelmenu
    public void duelStats() {
        System.out.println("HP: " + getCurrentHP() + " MP: " + getCurrentMP());
    }

}