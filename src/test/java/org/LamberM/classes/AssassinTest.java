package org.LamberM.classes;

import org.LamberM.enemy.Enemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.io.ByteArrayInputStream;

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
        int expectedMp = assassinTest.duelStats.getDuelMP()-20;
        // when
        assassinTest.skillsMenu();
        // then
        int expectedHp = enemyTest.enemyDuelStats.getDuelHP() - assassinTest.duelStats.getDamage();
        Assertions.assertEquals(expectedHp,enemyTest.enemyDuelStats.getDuelHP());
        Assertions.assertEquals(expectedMp,assassinTest.duelStats.getDuelMP());
    }
    @Test
    void boostDodgeAndDexterityTest()
    {
        // given
        assassinTest.setUserChoice(2); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassinTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        int expectedDex = assassinTest.duelStats.getDexterity()+10;
        int expectedDodge = assassinTest.duelStats.getDodge() + 5;
        int expectedCritC= assassinTest.duelStats.getCriticalChance()+5;
        int expectedMp = assassinTest.duelStats.getDuelMP()-20;
        // when
        assassinTest.skillsMenu();
        //then
        Assertions.assertEquals(expectedDex,assassinTest.duelStats.getDexterity());
        Assertions.assertEquals(expectedDodge,assassinTest.duelStats.getDodge());
        Assertions.assertEquals(expectedCritC,assassinTest.duelStats.getCriticalChance());
        Assertions.assertEquals(expectedMp,assassinTest.duelStats.getDuelMP());
    }
    @Test
    void criticalAttackTest()
    {
        // given
        assassinTest.setUserChoice(3); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassinTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        int expectedMp = assassinTest.duelStats.getDuelMP()-30;
        // when
        assassinTest.skillsMenu();
        // then
        int expectedHp = enemyTest.enemyDuelStats.getDuelHP() - assassinTest.duelStats.getDamage();
        Assertions.assertEquals(expectedHp,enemyTest.enemyDuelStats.getDuelHP());
        Assertions.assertEquals(expectedMp,assassinTest.duelStats.getDuelMP());
    }
}