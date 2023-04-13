package org.LamberM.character;

import org.LamberM.UnitTest;
import org.LamberM.utils.MenuChooser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WarriorTest implements UnitTest {
    @InjectMocks
    Warrior systemUnderTest;
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
        int expected = 55;
        //when
        int actual = systemUnderTest.attack();
        //then
        Assertions.assertEquals(expected, actual);
    }

    ///////////////////////attack skills tests/////////////////////////////////
    @Test
    void givenUserPickDoubleAttack_whenOffensiveSkillsMenu_thenDoubleAttack() {
        //given
        systemUnderTest.setOffensiveSkillsMenu(menuChooserMock);
        when(menuChooserMock.userPick()).thenReturn(1);
        int expected = 64;
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenNotEnoughMpToUseDoubleAttack_whenOffensiveSkillsMenu_thenCantUseDoubleAttack() {
        //given
        systemUnderTest.setOffensiveSkillsMenu(menuChooserMock);
        systemUnderTest.getDuelStats().setMp(systemUnderTest.getDuelStats().getMp() - 40);
        int expected = 9999;
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        assertEquals(expected, actual);
    }

    @Test
    void givenUserPickBackToMenu_whenOffensiveSkillsMenu_thenBackToMenu() {
        //given
        systemUnderTest.setOffensiveSkillsMenu(menuChooserMock);
        when(menuChooserMock.userPick()).thenReturn(2);
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(9999, actual);
    }
    ///////////////////////////////////defensive skills tests/////////////////////////

    @Test
    void givenUserPickBattleCry_whenDefensiveSkillsMenu_thenBattleCry() {
        // given
        systemUnderTest.setDefensiveSkillsMenu(menuChooserMock);
        int expectedStr = systemUnderTest.getDuelStats().getStrength() + 10;
        int expectedArmor = systemUnderTest.getDuelStats().getArmor() + 5;
        int expectedCritC = systemUnderTest.getDuelStats().getCriticalChance() + 2;
        int expectedMp = systemUnderTest.getDuelStats().getMp() - 20;
        when(menuChooserMock.userPick()).thenReturn(1);
        //when
        systemUnderTest.defensiveSkillsMenu();
        //then
        assertEquals(expectedStr, systemUnderTest.getDuelStats().getStrength());
        assertEquals(expectedArmor, systemUnderTest.getDuelStats().getArmor());
        assertEquals(expectedCritC, systemUnderTest.getDuelStats().getCriticalChance());
        assertEquals(expectedMp, systemUnderTest.getDuelStats().getMp());
    }

    @Test
    void givenNotEnoughMpToUseBattleCry_whenDefensiveSkillsMenu_thenCantUseBattleCry() {
        //given
        systemUnderTest.setDefensiveSkillsMenu(menuChooserMock);
        systemUnderTest.getDuelStats().setMp(systemUnderTest.getDuelStats().getMp() - 40);
        //when
        int actual = systemUnderTest.defensiveSkillsMenu();
        //then
        assertEquals(9999, actual);
    }

    @Test
    void defensiveCryTest() {
        // given
        systemUnderTest.setDefensiveSkillsMenu(menuChooserMock);
        int expectedHp = systemUnderTest.getDuelStats().getHp() + 20;
        int expectedArmor = systemUnderTest.getDuelStats().getArmor() + 10;
        int expectedDodge = systemUnderTest.getDuelStats().getDodge() + 2;
        int expectedMp = systemUnderTest.getDuelStats().getMp() - 20;
        when(menuChooserMock.userPick()).thenReturn(2);
        //when
        systemUnderTest.defensiveSkillsMenu();
        //then
        assertEquals(expectedHp, systemUnderTest.getDuelStats().getHp());
        assertEquals(expectedArmor, systemUnderTest.getDuelStats().getArmor());
        assertEquals(expectedDodge, systemUnderTest.getDuelStats().getDodge());
        assertEquals(expectedMp, systemUnderTest.getDuelStats().getMp());
    }

    @Test
    void givenNotEnoughMpToUseDefensiveCry_whenDefensiveSkillsMenu_thenCantUseDefensiveCry() {
        //given
        systemUnderTest.getDuelStats().setMp(systemUnderTest.getDuelStats().getMp() - 40);
        //when
        int actual = systemUnderTest.defensiveSkillsMenu();
        //then
        assertEquals(9999, actual);
    }

    @Test
    void givenUserPickBackToMenu_whenDefensiveSkillsMenu_thenBackToMenu() {
        //given
        systemUnderTest.setDefensiveSkillsMenu(menuChooserMock);
        when(menuChooserMock.userPick()).thenReturn(3);
        //when
        int actual = systemUnderTest.defensiveSkillsMenu();
        //then
        Assertions.assertEquals(9999, actual);
    }
}