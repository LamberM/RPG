package org.LamberM.stats;

import org.LamberM.utils.SystemOutWriter;


public class StatsShower {
    SystemOutWriter outWriter;

    public StatsShower() {
        outWriter = new SystemOutWriter();
    }

    public String showStats(Stats stats) {
        outWriter.setText("Stats:"+
                        "\nStrength: " + stats.getStrength()+
                        "\nDexterity: " + stats.getDexterity()+
                        "\nIntelligence: " + stats.getIntelligence()+
                        "\nHP: " + stats.getHp()+
                        "\nMP: " + stats.getMp()+
                        "\nDodge: " + stats.getDodge()+
                        "\nArmor: " + stats.getArmor()+
                        "\nCritical attack chance: " + stats.getCriticalChance()
                );
        return outWriter.show();
    }

}
