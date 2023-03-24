package org.LamberM.character;

import org.LamberM.stats.Stats;

public class Enemy extends Character{
    public Enemy()
    {
        super(new Stats(15, 20, 10, 150, 40, 10, 60, 10, 1));
    }
    @Override
    public int attack(){
        System.out.println("Enemy: ");
        int damage = 20 + duelStats.getStrength()+ duelStats.getDexterity();
        return damage;
    }

}
