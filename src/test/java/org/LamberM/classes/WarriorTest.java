package org.LamberM.classes;

import org.LamberM.enemy.Enemy;
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
        warriorTest.setUserChoice(3); // give us possibility to change our scanner in application
        String userInput = String.valueOf(warriorTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        int expectedStr = warriorTest.duelStats.getStrength() + 10;
        int expectedArmor = warriorTest.duelStats.getArmor()+5;
        int expectedCritC= warriorTest.duelStats.getCriticalChance()+2;
        int expectedMp = warriorTest.duelStats.getMp()-20;
        warriorTest.skillsMenu();
        //then
        assertEquals(expectedStr,warriorTest.duelStats.getStrength());
        assertEquals(expectedArmor,warriorTest.duelStats.getArmor());
        assertEquals(expectedCritC,warriorTest.duelStats.getCriticalChance());
        assertEquals(expectedMp,warriorTest.duelStats.getMp());
    }
    @Test
    void defensiveCryTest()
    {
        // given
        warriorTest.setUserChoice(3); // give us possibility to change our scanner in application
        String userInput = String.valueOf(warriorTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        int expectedHp = warriorTest.duelStats.getHp()+20;
        int expectedArmor = warriorTest.duelStats.getArmor()+10;
        int expectedDodge = warriorTest.duelStats.getDodge()+2;
        int expectedMp = warriorTest.duelStats.getMp()-20;
        warriorTest.skillsMenu();
        //then
        assertEquals(expectedHp,warriorTest.duelStats.getHp());
        assertEquals(expectedArmor,warriorTest.duelStats.getArmor());
        assertEquals(expectedDodge,warriorTest.duelStats.getDodge());
        assertEquals(expectedMp,warriorTest.duelStats.getMp());
    }
    @Test
    void doubleAttackTest()
    {
        // given
        warriorTest.setUserChoice(3); // give us possibility to change our scanner in application
        String userInput = String.valueOf(warriorTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        int expectedMp = warriorTest.duelStats.getMp()-20;
        warriorTest.skillsMenu();
        int expectedHp = enemyTest.enemyDuelStats.getHp() - warriorTest.duelStats.getDamage();
        // then
        assertEquals(expectedHp,enemyTest.enemyDuelStats.getHp());
        assertEquals(expectedMp,warriorTest.duelStats.getMp());
    }
}