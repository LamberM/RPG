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
        int currentHp = duelStats.getHp() + 20;
        int currentMp = duelStats.getMp() + 20;

        if (currentHp >= duelStats.getHp() || currentMp >= duelStats.getMp()) {
            duelStats.setHp(duelStats.getHp());
            duelStats.setMp(duelStats.getMp());
        } else {
            System.out.println("Your HP: " + duelStats.getHp());
            System.out.println("Your MP: " + duelStats.getMp());
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
        return getDuelStats().getMp() >= 20;
    }

}
