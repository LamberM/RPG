package org.LamberM.characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarriorTest extends ClassesTest {
    @InjectMocks
    Warrior systemUnderTest;
    @Mock
    Enemy enemy;
    @Test
    void battleCryTest()
    {
        // given
        systemUnderTest.setUserChoice(1); // give us possibility to change our scanner in application
        String userInput = String.valueOf(systemUnderTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        int expectedStr = systemUnderTest.duelStats.getStrength() + 10;
        int expectedArmor = systemUnderTest.duelStats.getArmor()+5;
        int expectedCritC= systemUnderTest.duelStats.getCriticalChance()+2;
        int expectedMp = systemUnderTest.duelStats.getDuelMP()-20;
        // when
        systemUnderTest.skillsMenu();
        //then
        Assertions.assertEquals(expectedStr, systemUnderTest.duelStats.getStrength());
        Assertions.assertEquals(expectedArmor, systemUnderTest.duelStats.getArmor());
        Assertions.assertEquals(expectedCritC, systemUnderTest.duelStats.getCriticalChance());
        Assertions.assertEquals(expectedMp, systemUnderTest.duelStats.getDuelMP());
    }
    @Test
    void defensiveCryTest()
    {
        // given
        systemUnderTest.setUserChoice(2); // give us possibility to change our scanner in application
        String userInput = String.valueOf(systemUnderTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        int expectedHp = systemUnderTest.duelStats.getDuelHP()+20;
        int expectedArmor = systemUnderTest.duelStats.getArmor()+10;
        int expectedDodge = systemUnderTest.duelStats.getDodge()+2;
        int expectedMp = systemUnderTest.duelStats.getDuelMP()-20;
        // when
        systemUnderTest.skillsMenu();
        //then
        Assertions.assertEquals(expectedHp, systemUnderTest.duelStats.getDuelHP());
        Assertions.assertEquals(expectedArmor, systemUnderTest.duelStats.getArmor());
        Assertions.assertEquals(expectedDodge, systemUnderTest.duelStats.getDodge());
        Assertions.assertEquals(expectedMp, systemUnderTest.duelStats.getDuelMP());
    }
    @Test
    void doubleAttackTest()
    {
        // given
        systemUnderTest.setUserChoice(3); // give us possibility to change our scanner in application
        String userInput = String.valueOf(systemUnderTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        int expectedMp = systemUnderTest.duelStats.getMp()-20;
        // when
        systemUnderTest.skillsMenu();
        // then
        int expectedHp = enemy.enemyDuelStats.getHp() - systemUnderTest.duelStats.getDamage();
        Assertions.assertEquals(expectedHp, enemy.enemyDuelStats.getHp());
        Assertions.assertEquals(expectedMp, systemUnderTest.duelStats.getMp());
    }
}