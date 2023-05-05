package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.character.Enemy;
import org.LamberM.character.Sorcerer;
import org.LamberM.utils.MenuChooser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;


class RoundMakerTest implements UnitTest {
    @InjectMocks
    RoundMaker systemUnderTest;
    @Mock
    MenuChooser menuChooserMock;
    @Mock
    OffensiveRoundMaker offensiveRoundMakerMock;
    @Mock
    DefensiveRoundMaker defensiveRoundMakerMock;

    @Test
    void givenUserPickAndHeroAndEnemyAndEnoughRange_whenPlayRound_thenMyHeroAndEnemyTryAttack() {
        //given
        systemUnderTest.setRange(1);
        Sorcerer myHero = new Sorcerer("does not matter");
        Enemy enemy = new Enemy("does not matter");
        when(menuChooserMock.userPick()).thenReturn(1);
        //when
        systemUnderTest.playRound(myHero, enemy);
        //then
        verify(offensiveRoundMakerMock).attack(myHero, enemy);
        verify(offensiveRoundMakerMock).attack(enemy, myHero);
    }

    @Test
    void givenUserPickAndHero_whenPlayRound_thenMyHeroCantAttack() {
        //given
        systemUnderTest.setRange(5);
        Sorcerer myHero = new Sorcerer("does not matter");
        Enemy enemy = new Enemy("does not matter");
        when(menuChooserMock.userPick()).thenReturn(1);
        //when
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> systemUnderTest.playRound(myHero, enemy));
        //then
        String expectedMessage = "You made mistakes too much";
        Assertions.assertTrue(expectedMessage.contains(illegalArgumentException.getMessage()));
    }

    @Test
    void givenUserPickAndHeroAndEnemyAndEnoughRange_whenPlayRound_thenMyHeroCanUseOffensiveSkills() {
        //given
        systemUnderTest.setRange(1);
        Sorcerer myHero = new Sorcerer("does not matter");
        Enemy enemy = new Enemy("does not matter");
        when(menuChooserMock.userPick()).thenReturn(2);
        //when
        systemUnderTest.playRound(myHero, enemy);
        //then
        verify(offensiveRoundMakerMock).offensiveSkills(myHero, enemy);
    }

    @Test
    void givenUserPickAndHeroWithNotEnoughMP_whenPlayRound_thenMyHeroCantUseOffensiveSkills() {
        //given
        Sorcerer myHero = new Sorcerer("does not matter");
        Enemy enemy = new Enemy("does not matter");
        systemUnderTest.setRange(1);
        myHero.getDuelStats().setMp(0);
        when(menuChooserMock.userPick()).thenReturn(2);
        //when
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> systemUnderTest.playRound(myHero, enemy));
        //then
        String expectedMessage = "You made mistakes too much";
        Assertions.assertTrue(expectedMessage.contains(illegalArgumentException.getMessage()));
    }

    @Test
    void givenUserPickAndHeroAndNotEnoughRange_whenPlayRound_thenMyHeroCantUseOffensiveSkills() {
        //given
        Sorcerer myHero = new Sorcerer("does not matter");
        Enemy enemy = new Enemy("does not matter");
        systemUnderTest.setRange(5);
        when(menuChooserMock.userPick()).thenReturn(2);
        //when
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> systemUnderTest.playRound(myHero, enemy));
        //then
        String expectedMessage = "You made mistakes too much";
        Assertions.assertTrue(expectedMessage.contains(illegalArgumentException.getMessage()));
    }


    @Test
    void givenUserPickAndHeroWithNotEnoughMP_whenPlayRound_thenMyHeroCantUseDefensiveSkills() {
        //given
        Sorcerer myHero = new Sorcerer("does not matter");
        Enemy enemy = new Enemy("does not matter");
        systemUnderTest.setRange(1);
        myHero.getDuelStats().setMp(0);
        when(menuChooserMock.userPick()).thenReturn(3);
        //when
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> systemUnderTest.playRound(myHero, enemy));
        //then
        String expectedMessage = "You made mistakes too much";
        Assertions.assertTrue(expectedMessage.contains(illegalArgumentException.getMessage()));
    }

    @Test
    void givenUserPickAndHeroAndEnemyAndEnoughMana_whenPlayRound_thenMyHeroCanUseDefensiveSkills() {
        //given
        Sorcerer myHero = new Sorcerer("does not matter");
        Enemy enemy = new Enemy("does not matter");
        when(menuChooserMock.userPick()).thenReturn(3);
        //when
        systemUnderTest.playRound(myHero, enemy);
        //then
        verify(defensiveRoundMakerMock).defensiveSkills(myHero);
    }

    @Test
    void givenUserPickAndHeroAndEnemywhenPlayRound_thenMyHeroCanUseRest() {
        //given
        Sorcerer myHero = new Sorcerer("does not matter");
        Enemy enemy = new Enemy("does not matter");
        when(menuChooserMock.userPick()).thenReturn(5);
        //when
        systemUnderTest.playRound(myHero, enemy);
        //then
        verify(defensiveRoundMakerMock).rest(myHero);
    }
}