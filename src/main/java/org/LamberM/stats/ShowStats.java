package org.LamberM.stats;

import org.LamberM.character.Character;

import java.util.ArrayList;
import java.util.List;

public class ShowStats {
    public ShowStats(Character character) {
        showStats(character);
    }

    public List<String> showStats(Character character)
    {
        List<String>showStats = new ArrayList<>();
        showStats.add("My hero stats:");
        showStats.add("Strength: " + character.getStats().getStrength());
        showStats.add("Dexterity: " + character.getStats().getDexterity());
        showStats.add("Intelligence: " + character.getStats().getIntelligence());
        showStats.add("HP: " + character.getStats().getHp());
        showStats.add("MP: " + character.getStats().getMp());
        showStats.add("Dodge: " + character.getStats().getDodge());
        showStats.add("Armor: " + character.getStats().getArmor());
        showStats.add("Critical attack chance: " + character.getStats().getCriticalChance());
        return showStats;
    }

}
