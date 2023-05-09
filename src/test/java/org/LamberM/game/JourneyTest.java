package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.character.Warrior;
import org.LamberM.stats.StatsShower;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.OutputWriter;
import org.LamberM.utils.SystemOutWriter;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

class JourneyTest implements UnitTest {
    @InjectMocks
    Journey systemUnderTest;
    @Mock
    MenuChooser journeyMenuChooserMock;
    @Mock
    StatsShower showStatsMock;
    @Mock
    OutputWriter outputWriterMock;
    @Mock
    DuelMaker duelMakerMock;
    @Mock
    EnemyCreator enemyCreatorMock;

    @Test
    void givenUserPick_whenContinueJourney_thenDuelCalled() {
        //given
        Warrior givenHero = new Warrior("does not matter");
        when(journeyMenuChooserMock.userPick()).thenReturn(1);
        //when
        systemUnderTest.startJourney(givenHero,enemyCreatorMock.createEnemy());
        //then
        verify(duelMakerMock).duelMenu(givenHero,enemyCreatorMock.createEnemy());
    }

    @Test
    void givenUserPickShowStats_whenContinueJourney_thenShowStatsCalled() {
        //given
        Warrior givenHero = new Warrior("does not matter");
        when(journeyMenuChooserMock.userPick()).thenReturn(2);
        //when
        systemUnderTest.startJourney(givenHero,enemyCreatorMock.createEnemy());
        //then
        verify(showStatsMock).showStats(givenHero.getStats());
    }

    // add stats później
    @Test
    void givenUserPick_whenContinueJourney_thenGameIsEnd() {
        //given
        Warrior givenHero = new Warrior("does not matter");
        String text = "Hello " + givenHero.getName() +
        "\nAre you ready for adventure ?" +
                "\nYour choice possibilities:";
        when(journeyMenuChooserMock.userPick()).thenReturn(4);

        //when
        systemUnderTest.startJourney(givenHero,enemyCreatorMock.createEnemy());
        //then
        verify(outputWriterMock).show(text);
    }
}