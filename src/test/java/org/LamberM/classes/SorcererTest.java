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
        int expectedMp = sorcererTest.duelStats.getMp()-20;
        sorcererTest.skillsMenu();
        int expectedHp = enemyTest.enemyDuelStats.getHp() - sorcererTest.duelStats.getDamage();
        // then
        assertEquals(expectedHp,enemyTest.enemyDuelStats.getHp());
        assertEquals(expectedMp,sorcererTest.duelStats.getMp());
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
        int expectedMp = sorcererTest.duelStats.getMp()-30;
        sorcererTest.skillsMenu();
        int expectedHp = enemyTest.enemyDuelStats.getHp() - sorcererTest.duelStats.getDamage();
        // then
        assertEquals(expectedHp,enemyTest.enemyDuelStats.getHp());
        assertEquals(expectedMp,sorcererTest.duelStats.getMp());
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
        int expectedArmor = sorcererTest.duelStats.getArmor()+10;
        int expectedMp = sorcererTest.duelStats.getMp()-20;
        sorcererTest.skillsMenu();
        //then
        assertEquals(expectedArmor,sorcererTest.duelStats.getArmor());
        assertEquals(expectedMp,sorcererTest.duelStats.getMp());
    }

}