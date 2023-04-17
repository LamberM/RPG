package org.LamberM.character;

import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assassin extends Character {

    public Assassin(String name) {
        super(name, assassinDefaultStats());
    }

    public static Stats assassinDefaultStats() {
        return new Stats(15, 20, 10, 150, 40, 10, 60, 10, 1);
    }

    @Override
    public MenuChooser provideDefensiveSkillsMenu() {
        return new MenuChooser(new SystemInReader(), List.of("1.Boost dodge and dexterity (20MP)", "2.Back to skill menu"));
    }

    @Override
    public Map<Integer, Runnable> provideDefensiveSkills() {
        Map<Integer, Runnable> defensiveSkillsMap = new HashMap<>();
        defensiveSkillsMap.put(1, this::boostDodgeAndDexterity);
        return defensiveSkillsMap;
    }

    @Override
    public MenuChooser provideOffensiveSkillsMenu() {
        return new MenuChooser(new SystemInReader(), List.of("1.Hit in the back (20MP)", "2.Critical attack (30MP)", "3.Back to skill menu"));
    }

    @Override
    public Map<Integer, Runnable> provideOffensiveSkills() {
        Map<Integer, Runnable> offensiveSkillsMap = new HashMap<>();
        offensiveSkillsMap.put(1, this::hitInTheBack);
        offensiveSkillsMap.put(2, this::criticalAttackSkill);
        return offensiveSkillsMap;
    }

    //////////////////////////////////// Offensive skills //////////////////////////////////////////////////////////
    private boolean currentMpIsEnoughToUseCriticalAttack() {
        return getDuelStats().getMp() >= 30;
    }

    private int criticalAttackSkill() {
        if (currentMpIsEnoughToUseCriticalAttack()) {
            return (40 + (getDuelStats().getDexterity() / 5));
        } else {
            System.out.println("You don't have enough mana point");
            return 9999;
        }
    }

    private int hitInTheBack() {
        getDuelStats().setMp(getDuelStats().getMp() - 20);
        return 30 + (getDuelStats().getDexterity() / 5);
    }

    //////////////////////////////////// Defensive skills //////////////////////////////////////////////////////////
    private void boostDodgeAndDexterity() {
        getDuelStats().setDexterity(getDuelStats().getDexterity() + 10);
        getDuelStats().setDodge(getDuelStats().getDodge() + 5);
        getDuelStats().setCriticalChance(getDuelStats().getCriticalChance() + 5);
        getDuelStats().setMp(getDuelStats().getMp() - 20);
        System.out.println("I'm feeling agile like ninja");
    }

}