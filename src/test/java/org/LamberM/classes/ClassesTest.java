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
    Classes classesTest = new Classes(){};
    @Mock
    Enemy enemyTest = new Enemy();
    @Test
    void chanceForAttackOrCriticalAttackTest()
    {
        //given
        int unexpectedValue = 0;
        //when
        classesTest.missOrBaseOrCritAttack();
        //then
        Assertions.assertNotEquals(unexpectedValue,classesTest.getHeroChance());
        Assertions.assertNotEquals(unexpectedValue,classesTest.getEnemyChance());
        Assertions.assertNotEquals(unexpectedValue,classesTest.getCritChance());
    }
    @Test
    void restTest()
    {
        //given
        int expectedHP = classesTest.duelStats.getHp();
        int expectedMP = classesTest.duelStats.getMp();
        //when
        classesTest.rest();
        //then
        Assertions.assertEquals(expectedHP,classesTest.duelStats.getDuelHP());
        Assertions.assertEquals(expectedMP,classesTest.duelStats.getDuelMP());

    }
    @Test
    void attackTest()
    {
        // given
        classesTest.setUserChoice(1); // give us possibility to change our scanner in application
        String userInput = String.valueOf(classesTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        classesTest.attackMenu();
        // then
        int extendedHp = enemyTest.enemyDuelStats.getDuelHP() - classesTest.duelStats.getDamage();
        Assertions.assertEquals(extendedHp,enemyTest.enemyDuelStats.getDuelHP());
    }
    @Test
    void strongAttackTest()
    {
        // given
        classesTest.setUserChoice(2); // give us possibility to change our scanner in application
        String userInput = String.valueOf(classesTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        classesTest.attackMenu();
        // then
        int extendedHp = enemyTest.enemyDuelStats.getHp() - classesTest.duelStats.getDamage();
        Assertions.assertEquals(extendedHp,enemyTest.enemyDuelStats.getHp());
    }
}