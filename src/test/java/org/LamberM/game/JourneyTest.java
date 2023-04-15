package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.character.Warrior;
import org.LamberM.stats.ShowStats;
import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.mockito.Mockito.*;

class JourneyTest implements UnitTest {
    @InjectMocks
    Journey systemUnderTest;
    @Mock
    Warrior warriorMock;
    @Mock
    MenuChooser continueJourneyMenuChooserMock;
    @Mock
    ShowStats showStatsMock;
    @Mock
    Duel duelMock;
    @Mock
    Stats statsMock;

    @Test
    void givenUserPick_whenContinueJourney_thenDuelCalled() {
        //given
        warriorMock = new Warrior("does not matter");
        systemUnderTest.setMyHero(warriorMock);
        systemUnderTest.setJourneyMenuChooser(continueJourneyMenuChooserMock);
        when(continueJourneyMenuChooserMock.userPick()).thenReturn(1);
        //when
        systemUnderTest.startJourney();
        //then
        verify(duelMock).duelMenu();
    }

    @Test
    void givenUserPickShowStats_whenContinueJourney_thenShowStatsCalled() {
        //given
        warriorMock = new Warrior("does not matter");
        statsMock = new Stats(20, 15, 10, 200, 40, 5, 100, 5, 1);
        systemUnderTest.setMyHero(warriorMock);
        systemUnderTest.setJourneyMenuChooser(continueJourneyMenuChooserMock);
        when(continueJourneyMenuChooserMock.userPick()).thenReturn(2);
        //when
        systemUnderTest.startJourney();
        //then
        verify(showStatsMock).showStats(warriorMock);
    }

    // add stats później
    @Test
    void givenUserPick_whenContinueJourney_thenGameIsEnd() {
        //given
        warriorMock = new Warrior("does not matter");
        systemUnderTest.setMyHero(warriorMock);
        systemUnderTest.setJourneyMenuChooser(continueJourneyMenuChooserMock);
        String expected =
                "Hello does not matter\r\n"+
                "Are you ready for adventure ?\r\n"+
                "Your choice possibilities:\r\n"+
                "See you later, bye\r\n";
        when(continueJourneyMenuChooserMock.userPick()).thenReturn(4);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //when
        systemUnderTest.startJourney();
        //then
        Assertions.assertEquals(expected, outContent.toString());
    }
}