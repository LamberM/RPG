package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.character.Enemy;
import org.LamberM.character.Warrior;
import org.LamberM.utils.MenuChooser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

class DuelTest implements UnitTest {
    @InjectMocks
    Duel systemUnderTest;
    @Mock
    Round roundMock;
    @Mock
    Warrior myHeroMock;
    @Mock
    Enemy enemyMock;
    @Mock
    Journey journeyMock;
    @Mock
    MenuChooser menuChooserMock;
    @Test
    void givenRound_whenDuelMenu_thenDuelIsNotOverAndRoundCounterPlusOne(){
        //given
        roundMock.setDuelMenuChooser(menuChooserMock);
        when(menuChooserMock.userPick()).thenReturn(4,4);
        //when
            systemUnderTest.duelMenu();
        //then
        verify(systemUnderTest, times(2)).duelMenu();
        Assertions.assertEquals(2,roundMock.getRoundCounter());
    }
    @Test
    void givenSetMyHeroHpToNullAndExpectedString_whenDuelMenu_thenEnemyWin(){
        //given
        systemUnderTest.setMyHero(myHeroMock);
        myHeroMock = new Warrior("does not matter");
        myHeroMock.getDuelStats().setHp(0);
        String expected = "You lost\nGAME IS OVER";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //when
        systemUnderTest.duelMenu();
        //then
        Assertions.assertEquals(expected,outContent.toString());
    }
    @Test
    void givenSetEnemyHpToNullAndExpectedString_whenDuelMenu_thenHeroWin(){
        //given
        systemUnderTest.setMyHero(myHeroMock);
        myHeroMock = new Warrior("does not matter");
        enemyMock.getDuelStats().setHp(0);
        String expected = "You won";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //when
        systemUnderTest.duelMenu();
        //then
        Assertions.assertEquals(expected,outContent.toString());
        verify(journeyMock);
    }
}