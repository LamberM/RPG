package org.LamberM.game;

import lombok.Getter;
import lombok.Setter;
import org.LamberM.character.Character;
import org.LamberM.character.Enemy;
import org.LamberM.character.MyClass;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemInReader;

import java.util.List;

public class Duel {

//    public Duel(Character hero , Character enemy)
//    {
//        hero = this.hero;
//        enemy= this.enemy;
//    }
    @Getter
    @Setter
    private int range = 3;
//    Character hero;
//    Character enemy;
    Round round = new Round();
    MenuChooser duelMenuChooser= new MenuChooser(new SystemInReader(),
            List.of(
                    "1.Attack",
                    "2.Offensive skills",
                    "3.Defensive skills",
                    "4.Step forward",
                    "5.Rest"
            )
    );

    private boolean heroCanUseSkill()
    {
        return (round.offensiveSkills() >= 0 && round.offensiveSkills() < 9999) || (round.defensiveSkills() >= 0 && round.defensiveSkills() <9999);
    }
    private void offensiveSkill()
    {
        round.offensiveSkills();
        while (!heroCanUseSkill())
        {
            duelMenu();
        }
        round.enemyAttack();
    }
    private void defensiveSkill()
    {
        round.defensiveSkills();
        while (!heroCanUseSkill())
        {
            duelMenu();
        }
        round.enemyAttack();
    }
    private void heroStatsInDuel()
    {
        System.out.println("My hero");
        System.out.println("HP: " + round.myHero.duelStats.getDuelHP() + "MP: " + round.myHero.duelStats.getDuelMP());

    }
    private void enemyStatsInDuel()
    {
        System.out.println("Enemy");
        System.out.println("HP: " + round.enemy.duelStats.getDuelHP());
    }
    private boolean heroWin()
    {
        return round.enemy.duelStats.getDuelHP() <=0;
    }
    private boolean enemyWin()
    {
        return round.myHero.duelStats.getDuelHP() <=0;
    }

    public void duelMenu() {

        while (!heroWin() || !enemyWin()) {
            heroStatsInDuel();
            enemyStatsInDuel();
            int userChoice = duelMenuChooser.userPick();
            switch (userChoice) {
                case 1 -> {
                    round.heroAttack();
                    round.enemyAttack();
                }
                case 2 -> offensiveSkill();
                case 3 -> defensiveSkill();
                case 4 -> {
                    range = range - 1;
                    round.enemyAttack();
                }
                case 5 -> round.rest();
            }
        }
        if (enemyWin()){
            System.out.println("You lost");
        } else if (heroWin()) {
            Journey journey = new Journey();
            System.out.println("You won");
            journey.mainMenu();
        }
    }

}
