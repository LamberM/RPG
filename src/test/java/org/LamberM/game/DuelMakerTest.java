package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.character.Enemy;
import org.LamberM.character.Warrior;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.mockito.Mockito.*;

class DuelMakerTest implements UnitTest {
    @InjectMocks
    DuelMaker systemUnderTest;
    @Mock
    RoundMaker roundMakerMock;
    @Mock
    Journey journeyMock;

    @Test
    void givenHeroEnemyAndSetMyHeroHpToZero_whenDuelMenu_thenEnemyWin(){
        //given
        Warrior givenHero = new Warrior("does not matter");
        Enemy enemy = new Enemy("does not matter");
        givenHero.getDuelStats().setHp(-1);
        //when
        systemUnderTest.duelMenu(givenHero,enemy);
        //then
        verifyNoInteractions(roundMakerMock);
    }
    @Test
    void givenHeroEnemyAndSetEnemyHpToZero_whenDuelMenu_thenHeroWin(){
        //given
        Warrior givenHero = new Warrior("does not matter");
        Enemy enemy = new Enemy("does not matter");
        enemy.getDuelStats().setHp(-1);
        //when
        systemUnderTest.duelMenu(givenHero,enemy);
        //then
        verify(journeyMock).startJourney(givenHero,enemy);
        verifyNoInteractions(roundMakerMock);
    }
    @Test
    void givenHeroAndEnemy_whenDuelMenu_thenRoundMaker(){
        //given
        Warrior givenHero = new Warrior("does not matter");
        Enemy enemy = new Enemy("does not matter");
        doAnswer(invocation -> {
            Warrior givenHero1 = invocation.getArgument(0);
            givenHero1.getDuelStats().setHp(-1);
            return null;
        }).when(roundMakerMock).playRound(givenHero,enemy);
        //when
        systemUnderTest.duelMenu(givenHero, enemy);
        //then
        verify(roundMakerMock).playRound(givenHero,enemy);
    }
}