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

public class WarriorTest implements UnitTest {
    @InjectMocks
    Warrior systemUnderTest;
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
        int expected= 55;
        //when
        int actual = systemUnderTest.attack();
        //then
        Assertions.assertEquals(expected,actual);
    }

    ///////////////////////attack skills tests/////////////////////////////////
    @Test
    void doubleAttackTest()
    {
        //given
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("1");
        int expected = 64;
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void cantUseDoubleAttack(){
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
        when(inputReaderMock.read()).thenReturn("2");
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(9999, actual);
    }
    ///////////////////////////////////defensive skills tests/////////////////////////

    @Test
    void battleCryTest() {
        // given
        int expectedStr = systemUnderTest.duelStats.getStrength() + 10;
        int expectedArmor = systemUnderTest.duelStats.getArmor()+5;
        int expectedCritC= systemUnderTest.duelStats.getCriticalChance()+2;
        int expectedMp = systemUnderTest.duelStats.getMp()-20;
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("1");
        //when
        systemUnderTest.defensiveSkillsMenu();
        //then
        assertEquals(expectedStr,systemUnderTest.duelStats.getStrength());
        assertEquals(expectedArmor,systemUnderTest.duelStats.getArmor());
        assertEquals(expectedCritC,systemUnderTest.duelStats.getCriticalChance());
        assertEquals(expectedMp,systemUnderTest.duelStats.getMp());
    }
    @Test
    void defensiveCryTest() {
        // given
        int expectedHp = systemUnderTest.duelStats.getHp()+20;
        int expectedArmor = systemUnderTest.duelStats.getArmor()+10;
        int expectedDodge = systemUnderTest.duelStats.getDodge()+2;
        int expectedMp = systemUnderTest.duelStats.getMp()-20;
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("1");
        //when
        systemUnderTest.defensiveSkillsMenu();
        //then
        assertEquals(expectedHp,systemUnderTest.duelStats.getHp());
        assertEquals(expectedArmor,systemUnderTest.duelStats.getArmor());
        assertEquals(expectedDodge,systemUnderTest.duelStats.getDodge());
        assertEquals(expectedMp,systemUnderTest.duelStats.getMp());
    }
    @Test
    void backToMenuInDefensiveSkillsMenu()
    {
        //given
        systemUnderTest.duelStats.setDuelMP(systemUnderTest.duelStats.getDuelMP() - 40);
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("3");
        //when
        int actual = systemUnderTest.defensiveSkillsMenu();
        //then
        Assertions.assertEquals(9999, actual);
    }
}