package org.LamberM.classes;

import org.LamberM.enemy.Enemy;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssassinTest extends ClassesTest {
    @InjectMocks
    Assassin assassinTest= new Assassin();
    @Mock
    Enemy enemyTest = new Enemy();
    @Test
    void hitInTheBackTest()
    {
        // given
        assassinTest.setUserChoice(1); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassinTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        int expectedMp = assassinTest.duelStats.getCurrentMP()-20;
        assassinTest.skillsMenu();
        int expectedHp = enemyTest.enemyDuelStats.getCurrentHP() - assassinTest.getDamage();
        // then
        assertEquals(expectedHp,enemyTest.enemyDuelStats.getCurrentHP());
        assertEquals(expectedMp,assassinTest.duelStats.getCurrentMP());
    }
    @Test
    void boostDodgeAndDexterityTest()
    {
        // given
        assassinTest.setUserChoice(2); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassinTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        int expectedDex = assassinTest.duelStats.getCurrentDex()+10;
        int expectedDodge = assassinTest.duelStats.getCurrentDodge() + 5;
        int expectedCritC= assassinTest.duelStats.getCurrentCritC()+5;
        int expectedMp = assassinTest.duelStats.getCurrentMP()-20;
        assassinTest.skillsMenu();
        //then
        assertEquals(expectedDex,assassinTest.duelStats.getCurrentDex());
        assertEquals(expectedDodge,assassinTest.duelStats.getCurrentDodge());
        assertEquals(expectedCritC,assassinTest.duelStats.getCurrentCritC());
        assertEquals(expectedMp,assassinTest.duelStats.getCurrentMP());
    }
    @Test
    void criticalAttackTest()
    {
        // given
        assassinTest.setUserChoice(3); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassinTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        int expectedMp = assassinTest.duelStats.getCurrentMP()-30;
        assassinTest.skillsMenu();
        int expectedHp = enemyTest.enemyDuelStats.getCurrentHP() - assassinTest.getDamage();
        // then
        assertEquals(expectedHp,enemyTest.enemyDuelStats.getCurrentHP());
        assertEquals(expectedMp,assassinTest.duelStats.getCurrentMP());
    }
}