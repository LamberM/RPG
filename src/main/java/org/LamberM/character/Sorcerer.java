package org.LamberM.character;


import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sorcerer extends Character {

    public Sorcerer(String name) {
        super(name, sorcererDefaultStats());
    }

    public static Stats sorcererDefaultStats() {
        return new Stats(5, 15, 25, 120, 80, 5, 40, 5, 2);
    }

    @Override
    public MenuChooser provideDefensiveSkillsMenu() {
        return new MenuChooser(new SystemInReader(), List.of("1.Frost armor (20MP)", "2.Back to skill menu"));
    }

    @Override
    public Map<Integer, Runnable> provideDefensiveSkills() {
        Map<Integer, Runnable> defensiveSkillsMap = new HashMap<>();
        defensiveSkillsMap.put(1, this::frostArmor);
        return defensiveSkillsMap;
    }

    @Override
    public MenuChooser provideOffensiveSkillsMenu() {
        return new MenuChooser(new SystemInReader(), List.of("1.Fire ball (20MP)", "2.Snow ball (30MP)", "3.Back to skill menu"));
    }

    @Override
    public Map<Integer, Runnable> provideOffensiveSkills() {
        Map<Integer, Runnable> offensiveSkillsMap = new HashMap<>();
        offensiveSkillsMap.put(1, this::fireBall);
        offensiveSkillsMap.put(2, this::snowBall);
        return offensiveSkillsMap;
    }

    //////////////////////////////////// Offensive skills //////////////////////////////////////////////////////////
    private int fireBall() {
        getDuelStats().setMp(getDuelStats().getMp() - 20);
        return 30 + (getDuelStats().getIntelligence() / 5);
    }


    private int snowBall() {
            getDuelStats().setMp(getDuelStats().getMp() - 30);
            return 30 + (getDuelStats().getIntelligence() / 5);
    }

    //////////////////////////////////// Defensive skills //////////////////////////////////////////////////////////
    private void frostArmor() {
        getDuelStats().setArmor(getDuelStats().getArmor() + 10);
        getDuelStats().setMp(getDuelStats().getMp() - 20);
        System.out.println("I feel freeze");
    }

}
