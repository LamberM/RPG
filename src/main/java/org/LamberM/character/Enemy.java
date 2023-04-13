package org.LamberM.character;

import org.LamberM.stats.Stats;

public class Enemy extends Character {
    public Enemy(String name, Stats stats) {
            super(name, new Stats(15, 20, 10, 150, 1, 10, 60, 10, 1));
    }

    @Override
    public int attack() {
        System.out.println("Enemy: ");
        int damage = 20 + getDuelStats().getStrength() + getDuelStats().getDexterity();
        return damage;
    }

}
