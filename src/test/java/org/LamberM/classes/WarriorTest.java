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
        int expectedStr = warriorTest.duelStats.getCurrentStr() + 10;
        int expectedArmor = warriorTest.duelStats.getCurrentArm()+5;
        int expectedCritC= warriorTest.duelStats.getCurrentCritC()+2;
        int expectedMp = warriorTest.duelStats.getCurrentMP()-20;
        warriorTest.skillsMenu();
        //then
        assertEquals(expectedStr,warriorTest.duelStats.getCurrentStr());
        assertEquals(expectedArmor,warriorTest.duelStats.getCurrentArm());
        assertEquals(expectedCritC,warriorTest.duelStats.getCurrentCritC());
        assertEquals(expectedMp,warriorTest.duelStats.getCurrentMP());
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
        int expectedHp = warriorTest.duelStats.getCurrentHP()+20;
        int expectedArmor = warriorTest.duelStats.getCurrentArm()+10;
        int expectedDodge = warriorTest.duelStats.getCurrentDodge()+2;
        int expectedMp = warriorTest.duelStats.getCurrentMP()-20;
        warriorTest.skillsMenu();
        //then
        assertEquals(expectedHp,warriorTest.duelStats.getCurrentHP());
        assertEquals(expectedArmor,warriorTest.duelStats.getCurrentArm());
        assertEquals(expectedDodge,warriorTest.duelStats.getCurrentDodge());
        assertEquals(expectedMp,warriorTest.duelStats.getCurrentMP());
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
        int expectedMp = warriorTest.duelStats.getCurrentMP()-20;
        warriorTest.skillsMenu();
        int expectedHp = enemyTest.enemyDuelStats.getCurrentHP() - warriorTest.getDamage();
        // then
        assertEquals(expectedHp,enemyTest.enemyDuelStats.getCurrentHP());
        assertEquals(expectedMp,warriorTest.duelStats.getCurrentMP());
    }
}