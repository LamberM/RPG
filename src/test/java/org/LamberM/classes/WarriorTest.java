package org.LamberM.classes;

import org.LamberM.enemy.Enemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarriorTest extends ClassesTest {
    @InjectMocks
    Warrior warriorTest = new Warrior();
    @Mock
    Enemy enemyTest = new Enemy();
    @Test
    void battleCryTest()
    {
        // given
        warriorTest.setUserChoice(1); // give us possibility to change our scanner in application
        String userInput = String.valueOf(warriorTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        int expectedStr = warriorTest.duelStats.getStrength() + 10;
        int expectedArmor = warriorTest.duelStats.getArmor()+5;
        int expectedCritC= warriorTest.duelStats.getCriticalChance()+2;
        int expectedMp = warriorTest.duelStats.getDuelMP()-20;
        // when
        warriorTest.skillsMenu();
        //then
        Assertions.assertEquals(expectedStr,warriorTest.duelStats.getStrength());
        Assertions.assertEquals(expectedArmor,warriorTest.duelStats.getArmor());
        Assertions.assertEquals(expectedCritC,warriorTest.duelStats.getCriticalChance());
        Assertions.assertEquals(expectedMp,warriorTest.duelStats.getDuelMP());
    }
    @Test
    void defensiveCryTest()
    {
        // given
        warriorTest.setUserChoice(2); // give us possibility to change our scanner in application
        String userInput = String.valueOf(warriorTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        int expectedHp = warriorTest.duelStats.getDuelHP()+20;
        int expectedArmor = warriorTest.duelStats.getArmor()+10;
        int expectedDodge = warriorTest.duelStats.getDodge()+2;
        int expectedMp = warriorTest.duelStats.getDuelMP()-20;
        // when
        warriorTest.skillsMenu();
        //then
        Assertions.assertEquals(expectedHp,warriorTest.duelStats.getDuelHP());
        Assertions.assertEquals(expectedArmor,warriorTest.duelStats.getArmor());
        Assertions.assertEquals(expectedDodge,warriorTest.duelStats.getDodge());
        Assertions.assertEquals(expectedMp,warriorTest.duelStats.getDuelMP());
    }
    @Test
    void doubleAttackTest()
    {
        // given
        warriorTest.setUserChoice(3); // give us possibility to change our scanner in application
        String userInput = String.valueOf(warriorTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        int expectedMp = warriorTest.duelStats.getMp()-20;
        // when
        warriorTest.skillsMenu();
        // then
        int expectedHp = enemyTest.enemyDuelStats.getHp() - warriorTest.duelStats.getDamage();
        Assertions.assertEquals(expectedHp,enemyTest.enemyDuelStats.getHp());
        Assertions.assertEquals(expectedMp,warriorTest.duelStats.getMp());
    }
}