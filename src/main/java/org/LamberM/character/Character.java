package org.LamberM.character;

import lombok.Getter;
import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;

import java.util.Map;
import java.util.concurrent.Callable;

public abstract class Character {

    @Getter
    private final String name;
    @Getter
    private final Stats stats;
    @Getter
    private Stats duelStats;


    public Character(String name, Stats statsParameters) {
        this.name = name;
        this.stats = statsParameters;
        this.duelStats = statsParameters;
    }

    public abstract MenuChooser provideDefensiveSkillsMenu();
    public abstract Map <Integer,Runnable> provideDefensiveSkills();
    public abstract MenuChooser provideOffensiveSkillsMenu();
    public abstract Map <Integer, Runnable> provideOffensiveSkills();
}
