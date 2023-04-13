package org.LamberM.character;

import org.LamberM.UnitTest;
import org.LamberM.utils.MenuChooser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

public class AssassinTest implements UnitTest {
    @InjectMocks
    Assassin systemUnderTest;
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
        Assertions.assertEquals(expectedHP, systemUnderTest.getDuelStats().getHp());
        Assertions.assertEquals(expectedMP, systemUnderTest.getDuelStats().getMp());
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
    void givenUserPickBackToMenu_whenOffensiveSkillsMenu_thenBackToMenu() {
        //given
        systemUnderTest.setOffensiveSkillsMenu(menuChooserMock);
        when(menuChooserMock.userPick()).thenReturn(3);
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(9999, actual);
    }

    @Test
    void givenUserPickCriticalAttackSkill_whenOffensiveSkillsMenu_thenCriticalAttackSkill() {
        //given
        systemUnderTest.setOffensiveSkillsMenu(menuChooserMock);
        when(menuChooserMock.userPick()).thenReturn(2);
        int expected = 44;
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenNotEnoughMpToUseCritAttackSkill_whenOffensiveSkillsMenu_thenCantUseCriticalAttackSkill() {
        //given
        systemUnderTest.setOffensiveSkillsMenu(menuChooserMock);
        systemUnderTest.getDuelStats().setMp(systemUnderTest.getDuelStats().getMp() - 40);
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(9999, actual);
    }

    @Test
    void givenUserPickHitInTheBack_whenOffensiveSkillsMenu_thenHitInTheBack() {
        //given
        systemUnderTest.setOffensiveSkillsMenu(menuChooserMock);
        when(menuChooserMock.userPick()).thenReturn(1);
        int expected = 34;
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenSetDuelMP_whenOffensiveSkillsMenu_thenCantUseHitInTheBack() {
        //given
        systemUnderTest.getDuelStats().setMp(systemUnderTest.getDuelStats().getMp() - 40);
        //when
        int actual = systemUnderTest.offensiveSkillsMenu();
        //then
        Assertions.assertEquals(9999, actual);
    }

    ///////////////////////////////////defensive skills tests/////////////////////////
    @Test
    void givenUserPickBoostDodgeAndDexterity_whenDefensiveSkillsMenu_thenBoostDodgeAndDexterity() {
        //given
        systemUnderTest.setDefensiveSkillsMenu(menuChooserMock);
        int expectedDex = systemUnderTest.getDuelStats().getDexterity() + 10;
        int expectedDodge = systemUnderTest.getDuelStats().getDodge() + 5;
        int expectedCritC = systemUnderTest.getDuelStats().getCriticalChance() + 5;
        int expectedMp = systemUnderTest.getDuelStats().getMp() - 20;
        when(menuChooserMock.userPick()).thenReturn(1);
        //when
        systemUnderTest.defensiveSkillsMenu();
        //then
        Assertions.assertEquals(expectedDex, systemUnderTest.getDuelStats().getDexterity());
        Assertions.assertEquals(expectedDodge, systemUnderTest.getDuelStats().getDodge());
        Assertions.assertEquals(expectedCritC, systemUnderTest.getDuelStats().getCriticalChance());
        Assertions.assertEquals(expectedMp, systemUnderTest.getDuelStats().getMp());
    }

    @Test
    void givenSetDuelMP_whenDefensiveSkillsMenu_thenCantUseBoostDodgeAndDexterity() {
        //given
        systemUnderTest.setDefensiveSkillsMenu(menuChooserMock);
        systemUnderTest.getDuelStats().setMp(systemUnderTest.getDuelStats().getMp() - 40);
        //when
        int actual = systemUnderTest.defensiveSkillsMenu();
        //then
        Assertions.assertEquals(9999, actual);
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