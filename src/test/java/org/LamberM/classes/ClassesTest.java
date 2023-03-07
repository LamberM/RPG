package org.LamberM.classes;

import org.LamberM.UnitTest;
import org.LamberM.enemy.Enemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.io.ByteArrayInputStream;


public class ClassesTest implements UnitTest
{
    @InjectMocks
    Classes systemUnderTest=new Classes() {};
    @Mock
    Enemy enemy;
    @Test
    void chanceForAttackOrCriticalAttackTest()
    {
        //given
        int unexpectedValue = 0;
        //when
        systemUnderTest.missOrBaseOrCritAttack();
        //then
        Assertions.assertNotEquals(unexpectedValue, systemUnderTest.getHeroChance());
        Assertions.assertNotEquals(unexpectedValue, systemUnderTest.getEnemyChance());
        Assertions.assertNotEquals(unexpectedValue, systemUnderTest.getCritChance());
    }
    @Test
    void restTest()
    {
        //given
        int expectedHP = systemUnderTest.duelStats.getHp();
        int expectedMP = systemUnderTest.duelStats.getMp();
        //when
        systemUnderTest.rest();
        //then
        Assertions.assertEquals(expectedHP, systemUnderTest.duelStats.getDuelHP());
        Assertions.assertEquals(expectedMP, systemUnderTest.duelStats.getDuelMP());

    }
    @Test
    void attackTest()
    {
        // given
        systemUnderTest.setUserChoice(1); // give us possibility to change our scanner in application
        String userInput = String.valueOf(systemUnderTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        systemUnderTest.attackMenu();
        // then
        int extendedHp = enemy.enemyDuelStats.getDuelHP() - systemUnderTest.duelStats.getDamage();
        Assertions.assertEquals(extendedHp, enemy.enemyDuelStats.getDuelHP());
    }
    @Test
    void strongAttackTest()
    {
        // given
        systemUnderTest.setUserChoice(2); // give us possibility to change our scanner in application
        String userInput = String.valueOf(systemUnderTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        systemUnderTest.attackMenu();
        // then
        int extendedHp = enemy.enemyDuelStats.getHp() - systemUnderTest.duelStats.getDamage();
        Assertions.assertEquals(extendedHp, enemy.enemyDuelStats.getHp());
    }
}