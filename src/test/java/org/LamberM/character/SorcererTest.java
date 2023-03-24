package org.LamberM.character;

import org.LamberM.UnitTest;
import org.LamberM.utils.InputReader;
import org.LamberM.utils.SystemInReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SorcererTest implements UnitTest {
    @InjectMocks
    Sorcerer systemUnderTest;
    @Mock
    InputReader inputReaderMock;
    ///////////////////////character methods //////////////////////////////////

    @Test
    void restTest() {
        //given
        int expectedHP = systemUnderTest.duelStats.getHp();
        int expectedMP = systemUnderTest.duelStats.getMp();
        //when
        systemUnderTest.rest();
        //then
        Assertions.assertEquals(expectedHP,systemUnderTest.duelStats.getDuelHP());
        Assertions.assertEquals(expectedMP,systemUnderTest.duelStats.getDuelMP());
    }

    @Test
    void attackTest() {
        //given
        int expected= 40;
        //when
        int actual = systemUnderTest.attack();
        //then
        Assertions.assertEquals(expected,actual);
    }

    ///////////////////////attack skills tests/////////////////////////////////
    @Test
    void snowBallTest()
    {
        //given
        systemUnderTest.duelStats.setDuelMP(systemUnderTest.duelStats.getDuelMP() - 80);
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("2");
        int expected = 50;
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void notEnoughMpToUseSnowBall()
    {
        //given
        systemUnderTest.duelStats.setDuelMP(systemUnderTest.duelStats.getDuelMP() - 40);
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("2");
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(9999, actual);
    }

    @Test
    void cantUseSnowBall(){
        //given
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("2");
        when(systemUnderTest.canUseAttackSkill()).thenReturn(false);
        int expected = 9999;
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void fireBallTest(){
        //given
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("1");
        int expected = 35;
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void cantUseFireBall(){
        //given
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("1");
        when(systemUnderTest.canUseAttackSkill()).thenReturn(false);
        int expected = 9999;
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void backToMenuInOffensiveSkillsMenu()
    {
        //given
        systemUnderTest.duelStats.setDuelMP(systemUnderTest.duelStats.getDuelMP() - 40);
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("3");
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(9999, actual);
    }
    ///////////////////////////////////defensive skills tests/////////////////////////

    @Test
    void frostArmorTest() {
        // given
        int expectedArmor = systemUnderTest.duelStats.getArmor()+10;
        int expectedMp = systemUnderTest.duelStats.getMp()-20;
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("1");
        //when
        systemUnderTest.defensiveSkillsMenu();
        //then
        assertEquals(expectedArmor,systemUnderTest.duelStats.getArmor());
        assertEquals(expectedMp,systemUnderTest.duelStats.getMp());
    }

    @Test
    void backToMenuInDefensiveSkillsMenu()
    {
        //given
        systemUnderTest.duelStats.setDuelMP(systemUnderTest.duelStats.getDuelMP() - 40);
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("2");
        //when
        int actual = systemUnderTest.defensiveSkillsMenu();
        //then
        Assertions.assertEquals(9999, actual);
    }
}