package org.LamberM.character;

import org.LamberM.UnitTest;
import org.LamberM.utils.MenuChooser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SorcererTest implements UnitTest {
    @InjectMocks
    Sorcerer systemUnderTest;
    @Mock
    MenuChooser menuChooserMock;
    ///////////////////////character methods //////////////////////////////////

    @Test
    void restTest() {
        //given
        int expectedHP = systemUnderTest.getDuelStats().getHp();
        int expectedMP = systemUnderTest.getDuelStats().getMp();
        //when
        systemUnderTest.rest();
        //then
        assertEquals(expectedHP, systemUnderTest.getDuelStats().getHp());
        assertEquals(expectedMP, systemUnderTest.getDuelStats().getMp());
    }

    @Test
    void attackTest() {
        //given
        int expected = 40;
        //when
        int actual = systemUnderTest.attack();
        //then
        Assertions.assertEquals(expected, actual);
    }

    ///////////////////////attack skills tests/////////////////////////////////
    @Test
    void givenUserPickSnowBall_whenOffensiveSkillsMenu_thenUseSnowBall() {
        //given
        systemUnderTest.setOffensiveSkillsMenu(menuChooserMock);
        when(menuChooserMock.userPick()).thenReturn(2);
        int expected = 50;
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenSetNotEnoughMpToUseSnowBall_whenOffensiveSkillsMenu_thenCantUseSnowBall() {
        //given
        systemUnderTest.setOffensiveSkillsMenu(menuChooserMock);
        systemUnderTest.getDuelStats().setMp(systemUnderTest.getDuelStats().getMp() - 80);
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        assertEquals(9999, actual);
    }

    @Test
    void givenUserPickFireBall_whenOffensiveSkillsMenu_thenUseFireBall() {
        //given
        systemUnderTest.setOffensiveSkillsMenu(menuChooserMock);
        when(menuChooserMock.userPick()).thenReturn(1);
        int expected = 35;
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenSetNotEnoughMpToUseFireBall_whenOffensiveSkillsMenu_thenCantUseFireBall() {
        //given
        systemUnderTest.setOffensiveSkillsMenu(menuChooserMock);
        systemUnderTest.getDuelStats().setMp(systemUnderTest.getDuelStats().getMp() - 80);
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        assertEquals(9999, actual);
    }

    @Test
    void givenUserPickBackToMenu_whenOffensiveSkillsMenu_thenBackToMenu() {
        //given
        systemUnderTest.setOffensiveSkillsMenu(menuChooserMock);
        when(menuChooserMock.userPick()).thenReturn(3);
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(9999, actual);
    }
    ////////////////////////////defensive skills tests///////////////////////////////////////

    @Test
    void givenUserPickFrostArmor_whenDefensiveSkillsMenu_thenFrostArmor() {
        // given
        systemUnderTest.setDefensiveSkillsMenu(menuChooserMock);
        int expectedArmor = systemUnderTest.getDuelStats().getArmor() + 10;
        int expectedMp = systemUnderTest.getDuelStats().getMp() - 20;
        when(menuChooserMock.userPick()).thenReturn(1);
        //when
        systemUnderTest.defensiveSkillsMenu();
        //then
        assertEquals(expectedArmor, systemUnderTest.getDuelStats().getArmor());
        assertEquals(expectedMp, systemUnderTest.getDuelStats().getMp());
    }

    @Test
    void givenUserPickBackToMenu_whenDefensiveSkillsMenu_thenBackToMenu() {
        //given
        systemUnderTest.setDefensiveSkillsMenu(menuChooserMock);
        when(menuChooserMock.userPick()).thenReturn(2);
        //when
        int actual = systemUnderTest.defensiveSkillsMenu();
        //then
        Assertions.assertEquals(9999, actual);
    }
}