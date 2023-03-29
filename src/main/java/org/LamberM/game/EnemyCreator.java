package org.LamberM.game;

import org.LamberM.character.Character;
import org.LamberM.character.Enemy;
import org.LamberM.stats.Stats;

import java.util.Random;

public class EnemyCreator {

    public Character createEnemy() {
        String name = createName();
        Stats stats = generateStats();
        return new Enemy(name, stats);
    }

    private String createName() {
        Random drawName = new Random();
        String name = "";
        int num = drawName.nextInt(5);
        switch (num) {
            case 0 -> name = "Brian";
            case 1 -> name = "Stevie";
            case 2 -> name = "Glen";
            case 3 -> name = "Chris";
            case 4 -> name = "Peter";
        }
        return name;
    }

    private Stats generateStats() {
        Random draw = new Random();
        int num = draw.nextInt(5);
        return new Stats(15 + num, 20 + num, 10 + num, 150 + (num * 10), 1, 10 + num, 60 + (num * 5), 10 + num, 1);
    }

}
