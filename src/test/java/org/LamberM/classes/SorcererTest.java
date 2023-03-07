package org.LamberM.classes;

import org.LamberM.enemy.Enemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorcererTest extends ClassesTest {
    @InjectMocks
    Sorcerer systemUnderTest;
    @Mock
    Enemy enemy;
    // testy nie działają poprawnie, ponieważ wartość enemyDualHp się zmienia
    @Test
    void fireBallTest()
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
    void snowBallTest()
    {
        // given
        systemUnderTest.setUserChoice(2); // give us possibility to change our scanner in application
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
    @Test
    void frostArmorTest()
    {
        // given
        systemUnderTest.setUserChoice(3); // give us possibility to change our scanner in application
        String userInput = String.valueOf(systemUnderTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        int expectedArmor = systemUnderTest.duelStats.getArmor()+10;
        int expectedMp = systemUnderTest.duelStats.getDuelMP()-20;
        // when
        systemUnderTest.skillsMenu();
        //then
        Assertions.assertEquals(expectedArmor, systemUnderTest.duelStats.getArmor());
        Assertions.assertEquals(expectedMp, systemUnderTest.duelStats.getDuelMP());
    }

}