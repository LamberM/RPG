package org.LamberM.game;

import org.LamberM.UnitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;


class RoundTest implements UnitTest {
    @InjectMocks
    Round systemUnderTest;

    @Test
    void heroAttackTest(){
        //given
        systemUnderTest.duel.setRange(1);
        int expected = systemUnderTest.enemy.duelStats.getDuelHP()-(systemUnderTest.myHero.attack()-systemUnderTest.enemy.duelStats.getArmor()/10);
        //when
        systemUnderTest.heroAttack();
        //then
        int actual = systemUnderTest.enemy.duelStats.getDuelHP();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void enemyAttackTest(){
        //given
        systemUnderTest.duel.setRange(1);
        int expected = systemUnderTest.myHero.duelStats.getDuelHP()-(systemUnderTest.enemy.attack()-systemUnderTest.myHero.duelStats.getArmor()/10);
        //when
        systemUnderTest.enemyAttack();
        //then
        int actual = systemUnderTest.myHero.duelStats.getDuelHP();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void offensiveSkillsTest(){
        //given
        systemUnderTest.duel.setRange(1);
        systemUnderTest.myHero.duelStats.setDuelMP(100);
        int expected = systemUnderTest.enemy.duelStats.getDuelHP()-(systemUnderTest.myHero.attack()-systemUnderTest.enemy.duelStats.getArmor()/10);
        //when
        systemUnderTest.offensiveSkills();
        //then
        int actual = systemUnderTest.enemy.duelStats.getDuelHP();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void heroAttackOrCritOrMissTest()
    {
        //given
        int unexpectedValue = 0;
        //when;
        systemUnderTest.heroAttackOrCritOrMiss();
        //then
        Assertions.assertNotEquals(unexpectedValue,systemUnderTest.getHeroChance());
        Assertions.assertNotEquals(unexpectedValue,systemUnderTest.getEnemyChance());
        Assertions.assertNotEquals(unexpectedValue,systemUnderTest.getCritChance());
    }
    @Test
    void enemyAttackOrCritOrMissTest()
    {
        //given
        int unexpectedValue = 0;
        //when;
        systemUnderTest.enemyAttackOrCritOrMiss();
        //then
        Assertions.assertNotEquals(unexpectedValue,systemUnderTest.getHeroChance());
        Assertions.assertNotEquals(unexpectedValue,systemUnderTest.getEnemyChance());
        Assertions.assertNotEquals(unexpectedValue,systemUnderTest.getCritChance());
    }
    @Test
    void  notEnoughRangeForHeroAttack()
    {
        //given
        systemUnderTest.duel.setRange(4);
        String expected = "You can't have to hit enemy. Your attack range is too small";
        //when
        systemUnderTest.heroAttack();
        //then
        String actual="";
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void  notEnoughRangeForEnemyAttack()
    {
        //given
        systemUnderTest.duel.setRange(4);
        int expected = 3;
        //when
        systemUnderTest.enemyAttack();
        //then
        int actual = systemUnderTest.duel.getRange();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void  notEnoughRangeForOffensiveSkills()
    {
        //given
        systemUnderTest.duel.setRange(4);
        int expected = 9999;
        //when
        int actual = systemUnderTest.offensiveSkills();
        //then
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void  notEnoughMpForOffensiveSkills()
    {
        //given
        systemUnderTest.myHero.duelStats.setDuelMP(1);
        int expected = 9999;
        //when
        int actual = systemUnderTest.offensiveSkills();
        //then
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void notEnoughMpForDefensiveSkills()
    {
        //given
        systemUnderTest.myHero.duelStats.setDuelMP(1);
        int expected = 9999;
        //when
        int actual = systemUnderTest.defensiveSkills();
        //then
        Assertions.assertEquals(expected,actual);
    }

}