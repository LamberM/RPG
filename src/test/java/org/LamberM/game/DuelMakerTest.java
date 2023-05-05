package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.character.Enemy;
import org.LamberM.character.Warrior;
import org.LamberM.stats.Stats;
import org.LamberM.utils.SystemOutWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.mockito.Mockito.*;

class DuelMakerTest implements UnitTest {
    @InjectMocks
    DuelMaker systemUnderTest;
    @Mock
    SystemOutWriter systemOutWriterMock;
    @Mock
    RoundMaker roundMakerMock;
    @Mock
    Journey journeyMock;

    @Test
    void givenHeroEnemyAndSetMyHeroHpToZero_whenDuelMenu_thenEnemyWin(){
        //given
        Enemy enemyMock = mock(Enemy.class);
        Warrior myHeroMock = mock(Warrior.class);
        Stats statsMock = mock(Stats.class);
        when(myHeroMock.getDuelStats()).thenReturn(statsMock);
        when(enemyMock.getDuelStats()).thenReturn(statsMock);
        myHeroMock.getDuelStats().setHp(0);
        //when
        systemUnderTest.duelMenu(myHeroMock,enemyMock);
        //then
        String expected = "Round number 1\nYou lost\nGAME IS OVER";
        Assertions.assertEquals(expected, systemOutWriterMock.show());
    }
    @Test
    void givenHeroEnemyAndSetEnemyHpToZero_whenDuelMenu_thenHeroWin(){
        //given
        Enemy enemyMock = mock(Enemy.class);
        Warrior myHeroMock = mock(Warrior.class);
        Stats statsMock = mock(Stats.class);
        when(myHeroMock.getDuelStats()).thenReturn(statsMock);
        when(enemyMock.getDuelStats()).thenReturn(statsMock);
        enemyMock.getDuelStats().setHp(0);
        //when
        systemUnderTest.duelMenu(myHeroMock,enemyMock);
        //then
//        String expected = "Round number 1\nYou won";
//        Assertions.assertEquals(expected, systemOutWriterMock.show());
        verify(journeyMock).startJourney(myHeroMock,enemyMock);
    }
    @Test
    void givenHeroAndEnemy_whenDuelMenu_thenRoundMaker(){
        //given
        Enemy enemyMock = mock(Enemy.class);
        Warrior myHeroMock = mock(Warrior.class);
        Stats statsMock = mock(Stats.class);
        when(myHeroMock.getDuelStats()).thenReturn(statsMock);
        when(enemyMock.getDuelStats()).thenReturn(statsMock);
        //when
        systemUnderTest.duelMenu(myHeroMock, enemyMock);
        //then
        verify(roundMakerMock).playRound(enemyMock,myHeroMock);
    }
}