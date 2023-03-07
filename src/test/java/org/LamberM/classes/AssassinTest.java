package org.LamberM.classes;

import org.LamberM.enemy.Enemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.io.ByteArrayInputStream;

public class AssassinTest extends ClassesTest {
    @InjectMocks
    Assassin systemUnderTest;
    @Mock
    Enemy enemy;
    @Test
    void hitInTheBackTest()
    {
        // given
        systemUnderTest.setUserChoice(1); // give us possibility to change our scanner in application
        String userInput = String.valueOf(systemUnderTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        int expectedMp = systemUnderTest.duelStats.getDuelMP()-20;
        // when
        systemUnderTest.skillsMenu();
        // then
        int expectedHp = enemy.enemyDuelStats.getDuelHP() - systemUnderTest.duelStats.getDamage();
        Assertions.assertEquals(expectedHp, enemy.enemyDuelStats.getDuelHP());
        Assertions.assertEquals(expectedMp, systemUnderTest.duelStats.getDuelMP());
    }
    @Test
    void boostDodgeAndDexterityTest()
    {
        // given
        systemUnderTest.setUserChoice(2); // give us possibility to change our scanner in application
        String userInput = String.valueOf(systemUnderTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        int expectedDex = systemUnderTest.duelStats.getDexterity()+10;
        int expectedDodge = systemUnderTest.duelStats.getDodge() + 5;
        int expectedCritC= systemUnderTest.duelStats.getCriticalChance()+5;
        int expectedMp = systemUnderTest.duelStats.getDuelMP()-20;
        // when
        systemUnderTest.skillsMenu();
        //then
        Assertions.assertEquals(expectedDex, systemUnderTest.duelStats.getDexterity());
        Assertions.assertEquals(expectedDodge, systemUnderTest.duelStats.getDodge());
        Assertions.assertEquals(expectedCritC, systemUnderTest.duelStats.getCriticalChance());
        Assertions.assertEquals(expectedMp, systemUnderTest.duelStats.getDuelMP());
    }
    @Test
    void criticalAttackTest()
    {
        // given
        systemUnderTest.setUserChoice(3); // give us possibility to change our scanner in application
        String userInput = String.valueOf(systemUnderTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        int expectedMp = systemUnderTest.duelStats.getDuelMP()-30;
        // when
        systemUnderTest.skillsMenu();
        // then
        int expectedHp = enemy.enemyDuelStats.getDuelHP() - systemUnderTest.duelStats.getDamage();
        Assertions.assertEquals(expectedHp, enemy.enemyDuelStats.getDuelHP());
        Assertions.assertEquals(expectedMp, systemUnderTest.duelStats.getDuelMP());
    }
}