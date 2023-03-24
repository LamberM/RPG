package org.LamberM.character;

import org.LamberM.UnitTest;
import org.LamberM.utils.InputReader;
import org.LamberM.utils.SystemInReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class AssassinTest implements UnitTest {
    @InjectMocks
    Assassin systemUnderTest;
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
    void criticalAttackSkillTest()
    {
        //given
        systemUnderTest.duelStats.setDuelMP(systemUnderTest.duelStats.getDuelMP() - 40);
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("2");
        int expected = 44;
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void notEnoughMpToUseCritAttackSkill()
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
    void cantUseCriticalAttackSkill(){
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
    void hitInTheBackTest(){
        //given
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("1");
        int expected = 34;
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void cantUseHitInTheBack(){
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
    void boostDodgeAndDexterityTest()
    {
        //given
        int expectedDex = systemUnderTest.duelStats.getDexterity()+10;
        int expectedDodge = systemUnderTest.duelStats.getDodge() + 5;
        int expectedCritC= systemUnderTest.duelStats.getCriticalChance()+5;
        int expectedMp = systemUnderTest.duelStats.getDuelMP()-20;
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("1");
        //when
        systemUnderTest.defensiveSkillsMenu();
        //then
        Assertions.assertEquals(expectedDex,systemUnderTest.duelStats.getDexterity());
        Assertions.assertEquals(expectedDodge,systemUnderTest.duelStats.getDodge());
        Assertions.assertEquals(expectedCritC,systemUnderTest.duelStats.getCriticalChance());
        Assertions.assertEquals(expectedMp,systemUnderTest.duelStats.getDuelMP());
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