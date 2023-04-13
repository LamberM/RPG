package org.LamberM.stats;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Stats {
    public Stats(int strength, int dexterity, int intelligence, int hp, int mp, int dodge, int armor, int criticalChance, int attackRange) {
//        if (!correctValues())
//        {
//            throw new IllegalArgumentException("Stats can't be less than 0");
//        }
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.hp = hp;
        this.mp = mp;
        this.dodge = dodge;
        this.armor = armor;
        this.criticalChance = criticalChance;
        this.attackRange = attackRange;
    }

    private int hp;
    private int mp;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int armor;
    private int dodge;
    private int criticalChance;
    private int attackRange;

//    private boolean correctValues()
//    {
//        return strength > 0 || dexterity > 0 || intelligence > 0 || hp > 0 || mp > 0 || dodge > 0 || armor > 0 || criticalChance > 0 || attackRange > 0;
//    }

}