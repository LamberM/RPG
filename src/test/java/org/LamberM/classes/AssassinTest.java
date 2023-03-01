package org.LamberM.classes;

import org.LamberM.enemy.Enemy;
import org.LamberM.game.Game;
import org.LamberM.game.GameTest;
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
    @Mock
    Game gameTest = new Game();
    @Test
    void hitInTheBackTest()
    {
        // given
        gameTest.setRange(1);
        assassinTest.setUserChoice(1); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassinTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        int expectedMp = assassinTest.duelStats.getDuelMP()-20;
        assassinTest.skillsMenu();
        int expectedHp = enemyTest.enemyDuelStats.getDuelHP() - assassinTest.duelStats.getDamage();
        // then
        assertEquals(expectedHp,enemyTest.enemyDuelStats.getDuelHP());
        assertEquals(expectedMp,assassinTest.duelStats.getDuelMP());
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
        int expectedDex = assassinTest.duelStats.getDexterity()+10;
        int expectedDodge = assassinTest.duelStats.getDodge() + 5;
        int expectedCritC= assassinTest.duelStats.getCriticalChance()+5;
        int expectedMp = assassinTest.duelStats.getDuelMP()-20;
        assassinTest.skillsMenu();
        //then
        assertEquals(expectedDex,assassinTest.duelStats.getDexterity());
        assertEquals(expectedDodge,assassinTest.duelStats.getDodge());
        assertEquals(expectedCritC,assassinTest.duelStats.getCriticalChance());
        assertEquals(expectedMp,assassinTest.duelStats.getDuelMP());
    }
    @Test
    void criticalAttackTest()
    {
        // given
        gameTest.setRange(1);
        assassinTest.setUserChoice(3); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassinTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        int expectedMp = assassinTest.duelStats.getDuelMP()-30;
        assassinTest.skillsMenu();
        int expectedHp = enemyTest.enemyDuelStats.getDuelHP() - assassinTest.duelStats.getDamage();
        // then
        assertEquals(expectedHp,enemyTest.enemyDuelStats.getDuelHP());
        assertEquals(expectedMp,assassinTest.duelStats.getDuelMP());
    }
}