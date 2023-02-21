package org.LamberM.classes;

import org.LamberM.enemy.Enemy;
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
    @Test
    void fireBallTest()
    {
        // given
        sorcererTest.setUserChoice(1); // give us possibility to change our scanner in application
        String userInput = String.valueOf(sorcererTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        int expectedMp = sorcererTest.duelStats.getCurrentMP()-20;
        sorcererTest.skillsMenu();
        int expectedHp = enemyTest.enemyDuelStats.getCurrentHP() - sorcererTest.getDamage();
        // then
        assertEquals(expectedHp,enemyTest.enemyDuelStats.getCurrentHP());
        assertEquals(expectedMp,sorcererTest.duelStats.getCurrentMP());
    }
    @Test
    void snowBallTest()
    {
        // given
        sorcererTest.setUserChoice(2); // give us possibility to change our scanner in application
        String userInput = String.valueOf(sorcererTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        int expectedMp = sorcererTest.duelStats.getCurrentMP()-30;
        sorcererTest.skillsMenu();
        int expectedHp = enemyTest.enemyDuelStats.getCurrentHP() - sorcererTest.getDamage();
        // then
        assertEquals(expectedHp,enemyTest.enemyDuelStats.getCurrentHP());
        assertEquals(expectedMp,sorcererTest.duelStats.getCurrentMP());
    }
    @Test
    void frostArmorTest()
    {
        // given
        sorcererTest.setUserChoice(3); // give us possibility to change our scanner in application
        String userInput = String.valueOf(sorcererTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        int expectedArmor = sorcererTest.duelStats.getCurrentArm()+10;
        int expectedMp = sorcererTest.duelStats.getCurrentMP()-20;
        sorcererTest.skillsMenu();
        //then
        assertEquals(expectedArmor,sorcererTest.duelStats.getCurrentArm());
        assertEquals(expectedMp,sorcererTest.duelStats.getCurrentMP());
    }

}