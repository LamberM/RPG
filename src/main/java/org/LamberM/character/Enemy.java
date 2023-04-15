package org.LamberM.character;

import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;

import java.util.Map;

public class Enemy extends Character {
    public Enemy(String name, Stats stats) {
            super(name, new Stats(15, 20, 10, 150, 1, 10, 60, 10, 1));
    }

    @Override
    public MenuChooser provideDefensiveSkillsMenu() {
        return null;
    }
    @Override
    public Map<Integer, Runnable> provideDefensiveSkills() {
        return null;
    }
    @Override
    public MenuChooser provideOffensiveSkillsMenu() {
        return null;
    }

    @Override
    public Map<Integer, Runnable> provideOffensiveSkills() {
        return null;
    }
}
