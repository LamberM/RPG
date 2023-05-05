package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.character.Enemy;
import org.LamberM.character.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;


class OffensiveRoundMakerTest implements UnitTest {
    @InjectMocks
    OffensiveRoundMaker systemUnderTest;

    @Test
    void givenHeroAndEnemy_whenHeroAttack_thenDamage() {
        //given
        Warrior givenHero = new Warrior("does not matter");
        Enemy givenEnemy = new Enemy("does not matter");
        int enemyHpBeforeHeroAttack = givenEnemy.getDuelStats().getHp();
        //when
        systemUnderTest.attack(givenHero, givenEnemy);
        //then
        int enemyHpAfterHeroAttack = givenEnemy.getDuelStats().getHp();
        Assertions.assertTrue(enemyHpAfterHeroAttack <= enemyHpBeforeHeroAttack);
    }

    @Test
    void givenHeroAndEnemy_whenEnemyAttack_thenDamage() {
        //given
        Warrior givenHero = new Warrior("does not matter");
        Enemy givenEnemy = new Enemy("does not matter");
        int myHeroHpBeforeEnemyAttack = givenHero.getDuelStats().getHp();
        //when
        systemUnderTest.attack(givenEnemy, givenHero);
        //then
        int myHeroHpAfterEnemyAttack = givenHero.getDuelStats().getHp();
        Assertions.assertTrue(myHeroHpAfterEnemyAttack <= myHeroHpBeforeEnemyAttack);
    }

    @Test
    void givenHeroAndEnemy_whenOffensiveSkills_thenDamage() {
        //given
        Warrior givenHero = new Warrior("does not matter");
        Enemy givenEnemy = new Enemy("does not matter");
        int enemyHpBeforeHeroAttack = givenEnemy.getDuelStats().getHp();
        //when
        systemUnderTest.offensiveSkills(givenHero, givenEnemy);
        //then
        int enemyHpAfterHeroAttack = givenEnemy.getDuelStats().getHp();
        Assertions.assertTrue(enemyHpAfterHeroAttack <= enemyHpBeforeHeroAttack);
    }
}