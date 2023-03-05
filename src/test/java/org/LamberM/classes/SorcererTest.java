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
    Sorcerer sorcererTest= new Sorcerer();
    @Mock
    Enemy enemyTest = new Enemy();
    // testy nie działają poprawnie, ponieważ wartość enemyDualHp się zmienia
    @Test
    void fireBallTest()
    {
        // given
        sorcererTest.setUserChoice(1); // give us possibility to change our scanner in application
        String userInput = String.valueOf(sorcererTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        int expectedMp = sorcererTest.duelStats.getDuelMP()-20;
        // when
        sorcererTest.skillsMenu();
        // then
        int expectedHp = enemyTest.enemyDuelStats.getDuelHP() - sorcererTest.duelStats.getDamage();
        Assertions.assertEquals(expectedHp,enemyTest.enemyDuelStats.getDuelHP());
        Assertions.assertEquals(expectedMp,sorcererTest.duelStats.getDuelMP());
    }
    @Test
    void snowBallTest()
    {
        // given
        sorcererTest.setUserChoice(2); // give us possibility to change our scanner in application
        String userInput = String.valueOf(sorcererTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        int expectedMp = sorcererTest.duelStats.getDuelMP()-30;
        // when
        sorcererTest.skillsMenu();
        // then
        int expectedHp = enemyTest.enemyDuelStats.getDuelHP() - sorcererTest.duelStats.getDamage();
        Assertions.assertEquals(expectedHp,enemyTest.enemyDuelStats.getDuelHP());
        Assertions.assertEquals(expectedMp,sorcererTest.duelStats.getDuelMP());
    }
    @Test
    void frostArmorTest()
    {
        // given
        sorcererTest.setUserChoice(3); // give us possibility to change our scanner in application
        String userInput = String.valueOf(sorcererTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        int expectedArmor = sorcererTest.duelStats.getArmor()+10;
        int expectedMp = sorcererTest.duelStats.getDuelMP()-20;
        // when
        sorcererTest.skillsMenu();
        //then
        Assertions.assertEquals(expectedArmor,sorcererTest.duelStats.getArmor());
        Assertions.assertEquals(expectedMp,sorcererTest.duelStats.getDuelMP());
    }

}