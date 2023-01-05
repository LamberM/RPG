package stats;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroStats
{
    Stats stats;
    private int attackRange = stats.getAttackRange();
    private int currentHP=stats.getHp();
    private int currentMP=stats.getMp();
    private int currentArm=stats.getArmor();
    private int currentStr=stats.getStrength();
    private int currentInt=stats.getIntelligence();
    private int currentDex=stats.getDexterity();
    private int currentCritC=stats.getCriticalChance();
    private int currentDodge=stats.getDodge();
    // dualstats need in duelmenu
    public void duelStats()
    {
        System.out.println("HP: " + currentHP + " MP: " + currentMP);
    }
    public void showStats()
    {
        System.out.println("Strength: " + this.currentStr);
        System.out.println("Dexterity: " + this.currentDex);
        System.out.println("Intelligence: " + this.currentInt);
        System.out.println("HP: " + this.currentHP);
        System.out.println("MP: " + this.currentMP);
        System.out.println("Dodge: " + this.currentDodge);
        System.out.println("Armor: " + this.currentArm);
        System.out.println("Critical attack chance: " + this.currentCritC);
    }
}
