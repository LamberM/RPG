package org.LamberM.stats;

import org.LamberM.utils.OutputWriter;
import org.LamberM.utils.SystemOutWriter;


public class StatsShower {
    private final OutputWriter outputWriter;

    public StatsShower() {
        outputWriter = new SystemOutWriter();
    }

    public String showStats(Stats stats) {
        return outputWriter.show("Stats:" +
                "\nStrength: " + stats.getStrength() +
                "\nDexterity: " + stats.getDexterity() +
                "\nIntelligence: " + stats.getIntelligence() +
                "\nHP: " + stats.getHp() +
                "\nMP: " + stats.getMp() +
                "\nDodge: " + stats.getDodge() +
                "\nArmor: " + stats.getArmor() +
                "\nCritical attack chance: " + stats.getCriticalChance()
        );
    }

}
