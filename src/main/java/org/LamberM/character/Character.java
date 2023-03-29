package org.LamberM.character;

import lombok.Getter;
import org.LamberM.stats.Stats;

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

    public void rest() {
        duelStats.setDuelHP(duelStats.getDuelHP() + 20);
        duelStats.setDuelMP(duelStats.getDuelMP() + 20);
        if (currentHpIsMoreThanMax()) {
            duelStats.setDuelHP(duelStats.getHp());
            duelStats.setDuelMP(duelStats.getMp());
        } else {
            System.out.println("Your HP: " + duelStats.getDuelHP());
            System.out.println("Your MP: " + duelStats.getDuelMP());
        }
    }

    public int attack() {
        System.out.println("My hero: ");
        return 20 + duelStats.getStrength() + duelStats.getDexterity();
    }

    public int offensiveSkillsMenu() {
        return 0;
    }

    public int defensiveSkillsMenu() {
        return 0;
    }

    protected boolean myHeroCanUseSkill() {
        return getDuelStats().getDuelMP() >= 20;
    }

    private boolean currentHpIsMoreThanMax() {
        return duelStats.getDuelHP() > duelStats.getHp() || duelStats.getDuelMP() > duelStats.getMp();
    }
}
