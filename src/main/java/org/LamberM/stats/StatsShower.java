package org.LamberM.stats;

import java.util.ArrayList;
import java.util.List;

public class StatsShower {

    public List<String> showStats(Stats stats) {
        List<String> showStats = new ArrayList<>();
        showStats.add("Stats:");
        showStats.add("Strength: " + stats.getStrength());
        showStats.add("Dexterity: " + stats.getDexterity());
        showStats.add("Intelligence: " + stats.getIntelligence());
        showStats.add("HP: " + stats.getHp());
        showStats.add("MP: " + stats.getMp());
        showStats.add("Dodge: " + stats.getDodge());
        showStats.add("Armor: " + stats.getArmor());
        showStats.add("Critical attack chance: " + stats.getCriticalChance());
        return showStats;
    }

}
