package org.LamberM.game;

import org.LamberM.character.Assassin;
import org.LamberM.character.Sorcerer;
import org.LamberM.character.Warrior;

import java.util.ArrayList;
import java.util.List;

public class InfoAboutClass {
    public List<String> infoAboutClass()
    {
        Warrior warrior=new Warrior();
        Assassin assassin= new Assassin();
        Sorcerer sorcerer= new Sorcerer();
        List<String>showStats = new ArrayList<>();
        showStats.add("All class stats:");
        showStats.add("Warrior stats:");
        showStats.add("Strength: " + warrior.getStats().getStrength());
        showStats.add("Dexterity: " + warrior.getStats().getDexterity());
        showStats.add("Intelligence: " + warrior.getStats().getIntelligence());
        showStats.add("HP: " + warrior.getStats().getHp());
        showStats.add("MP: " + warrior.getStats().getMp());
        showStats.add("Dodge: " + warrior.getStats().getDodge());
        showStats.add("Armor: " + warrior.getStats().getArmor());
        showStats.add("Critical attack chance: " + warrior.getStats().getCriticalChance());
        showStats.add("Assassin stats:");
        showStats.add("Strength: " + assassin.getStats().getStrength());
        showStats.add("Dexterity: " + assassin.getStats().getDexterity());
        showStats.add("Intelligence: " + assassin.getStats().getIntelligence());
        showStats.add("HP: " + assassin.getStats().getHp());
        showStats.add("MP: " + assassin.getStats().getMp());
        showStats.add("Dodge: " + assassin.getStats().getDodge());
        showStats.add("Armor: " + assassin.getStats().getArmor());
        showStats.add("Critical attack chance: " + assassin.getStats().getCriticalChance());
        showStats.add("Sorcerer stats:");
        showStats.add("Strength: " + sorcerer.getStats().getStrength());
        showStats.add("Dexterity: " + sorcerer.getStats().getDexterity());
        showStats.add("Intelligence: " + sorcerer.getStats().getIntelligence());
        showStats.add("HP: " + sorcerer.getStats().getHp());
        showStats.add("MP: " + sorcerer.getStats().getMp());
        showStats.add("Dodge: " + sorcerer.getStats().getDodge());
        showStats.add("Armor: " + sorcerer.getStats().getArmor());
        showStats.add("Critical attack chance: " + sorcerer.getStats().getCriticalChance());
        return showStats;
    }
}
