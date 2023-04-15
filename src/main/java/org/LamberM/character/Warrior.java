package org.LamberM.character;

import lombok.Setter;
import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, new Stats(20, 15, 10, 200, 40, 5, 100, 5, 1));
    }

    @Override
    public MenuChooser provideDefensiveSkillsMenu() {
        return new MenuChooser(new SystemInReader(), List.of("1.Battle cry (20MP)", "2.Defensive cry (20MP)", "2.Back to skill menu"));
    }

    @Override
    public Map<Integer, Runnable> provideDefensiveSkills() {
        Map<Integer,Runnable> defensiveSkillsMap = new HashMap<>();
        defensiveSkillsMap.put(1,this::battleCry);
        defensiveSkillsMap.put(2,this::defensiveCry);
        return defensiveSkillsMap;
    }
    @Override
    public MenuChooser provideOffensiveSkillsMenu() {
        return new MenuChooser(new SystemInReader(), List.of("1.Double attack (20MP)", "2.Back to skill menu"));
    }
    @Override
    public Map<Integer, Runnable> provideOffensiveSkills() {
        Map<Integer,Runnable> offensiveSkillsMap = new HashMap<>();
        offensiveSkillsMap.put(1,this::doubleAttack);
        return offensiveSkillsMap;
    }
    //////////////////////////////////// Defensive skills //////////////////////////////////////////////////////////
    private void battleCry() {
        getDuelStats().setStrength(getDuelStats().getStrength() + 10);
        getDuelStats().setArmor(getDuelStats().getArmor() + 5);
        getDuelStats().setCriticalChance(getDuelStats().getCriticalChance() + 2);
        getDuelStats().setMp((getDuelStats().getMp() - 20));
        System.out.println("WAAAAAAAAAAAAAAAAAAAAAAAAAAARRRRRRRRRRR");
    }

    private void defensiveCry() {
        getDuelStats().setHp(getDuelStats().getHp() + 20);
        getDuelStats().setArmor(getDuelStats().getArmor() + 10);
        getDuelStats().setDodge(getDuelStats().getDodge() + 2);
        getDuelStats().setMp((getDuelStats().getMp() - 20));
        System.out.println("BAAAAAAAAAAAAAAAAAAAAAAAACCCCCKKKKKKKKKKKKKK");
    }

    //////////////////////////////////// Offensive skills //////////////////////////////////////////////////////////
    private int doubleAttack() {
        getDuelStats().setMp((getDuelStats().getMp() - 20));
        return 60 + (getDuelStats().getStrength() / 5);
    }
}
