package org.LamberM.character;

import lombok.Getter;
import lombok.Setter;
import org.LamberM.game.Duel;
import org.LamberM.stats.Stats;

@Getter
public abstract class Character {

    @Getter
    @Setter
    private final Stats stats;
    public Stats duelStats;
    public Character (Stats statsParameters)
    {
        this.stats = statsParameters;
        this.duelStats = statsParameters;
    }


    protected boolean canUseAttackSkill(){
        Duel duel = new Duel();
        return duelStats.getAttackRange() >= duel.getRange();
    }

    private boolean currentHpIsMoreThanMax()
    {
        return duelStats.getDuelHP() > duelStats.getHp() || duelStats.getDuelMP() > duelStats.getMp();
    }
    public void rest()
    {
        duelStats.setDuelHP(duelStats.getDuelHP() + 20);
        duelStats.setDuelMP(duelStats.getDuelMP() + 20);
        if (currentHpIsMoreThanMax())
        {
            duelStats.setDuelHP(duelStats.getHp());
            duelStats.setDuelMP(duelStats.getMp());
        }
        else
        {
            System.out.println("Your HP: "+duelStats.getDuelHP());
            System.out.println("Your MP: "+duelStats.getDuelMP());
        }
    }
    public int attack(){
        System.out.println("My hero: ");
            int damage = 20 + duelStats.getStrength()+ duelStats.getDexterity();
            return damage;
    }

    public int offensiveSkillsMenu(){return 0;}
    public int defensiveSkillsMenu(){return 0;}


}
