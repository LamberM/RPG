package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.character.Enemy;
import org.LamberM.character.Warrior;
import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;


class RoundTest implements UnitTest {
    @InjectMocks
    Round systemUnderTest;
    @Mock
    MenuChooser menuChooserMock;
    @Mock
    OffensiveRound offensiveRoundMock;
    @Mock
    DefensiveRound defensiveRoundMock;
    @Mock
    Warrior myHeroMock;
    @Mock
    Enemy enemyMock;

    @Test
    void givenUserPickAndHeroAndEnemyAndEnoughRange_whenPlayRound_thenMyHeroAndEnemyTryAttack() {
        //given
        systemUnderTest.setDuelMenuChooser(menuChooserMock);
        systemUnderTest.setEnemy(enemyMock);
        systemUnderTest.setMyHero(myHeroMock);
        enemyMock = new Enemy("does not matter", new Stats(15, 20, 10, 150, 1, 10, 60, 10, 1));
        myHeroMock = new Warrior("does not matter");
        systemUnderTest.setRange(1);
        when(menuChooserMock.userPick()).thenReturn(1);
        //when
        systemUnderTest.playRound();
        //then
        verify(offensiveRoundMock).heroAttack();
        verify(offensiveRoundMock).enemyAttack();
    }

    @Test
    void givenUserPickAndHero_whenPlayRound_thenMyHeroCantAttack() {
        //given
        systemUnderTest.setDuelMenuChooser(menuChooserMock);
        systemUnderTest.setEnemy(enemyMock);
        systemUnderTest.setMyHero(myHeroMock);
        enemyMock = new Enemy("does not matter", new Stats(15, 20, 10, 150, 1, 10, 60, 10, 1));
        myHeroMock = new Warrior("does not matter");
        systemUnderTest.setRange(10);
        when(menuChooserMock.userPick()).thenReturn(1,1);
        doThrow(NullPointerException.class).when(systemUnderTest).playRound();
        //when
            systemUnderTest.playRound();
        //then
        verify(systemUnderTest, times(2)).playRound();
    }

    @Test
    void givenUserPickAndHeroAndEnemyAndEnoughRange_whenPlayRound_thenMyHeroCanUseOffensiveSkills() {
        //given
        systemUnderTest.setDuelMenuChooser(menuChooserMock);
        systemUnderTest.setEnemy(enemyMock);
        systemUnderTest.setMyHero(myHeroMock);
        enemyMock = new Enemy("does not matter", new Stats(15, 20, 10, 150, 1, 10, 60, 10, 1));
        myHeroMock = new Warrior("does not matter");
        systemUnderTest.setRange(1);
        when(menuChooserMock.userPick()).thenReturn(2);
        //when
        systemUnderTest.playRound();
        //then
        verify(offensiveRoundMock).offensiveSkills();
        verify(offensiveRoundMock).enemyAttack();
    }

    @Test
    void givenUserPickAndHeroWithNotEnoughMP_whenPlayRound_thenMyHeroCantUseOffensiveSkills() {
        //given
        systemUnderTest.setDuelMenuChooser(menuChooserMock);
        systemUnderTest.setEnemy(enemyMock);
        systemUnderTest.setMyHero(myHeroMock);
        enemyMock = new Enemy("does not matter", new Stats(15, 20, 10, 150, 1, 10, 60, 10, 1));
        myHeroMock = new Warrior("does not matter");
        myHeroMock.getDuelStats().setMp(0);
        when(menuChooserMock.userPick()).thenReturn(2,2);
        doThrow(NullPointerException.class).when(systemUnderTest).playRound();
        //when
            systemUnderTest.playRound();

        //then
        verify(systemUnderTest, times(2)).playRound();
    }

    @Test
    void givenUserPickAndHeroAndNotEnoughRange_whenPlayRound_thenMyHeroCantUseOffensiveSkills() {
        //given
        systemUnderTest.setDuelMenuChooser(menuChooserMock);
        systemUnderTest.setEnemy(enemyMock);
        systemUnderTest.setMyHero(myHeroMock);
        systemUnderTest.setRange(10);
        enemyMock = new Enemy("does not matter", new Stats(15, 20, 10, 150, 1, 10, 60, 10, 1));
        myHeroMock = new Warrior("does not matter");
        when(menuChooserMock.userPick()).thenReturn(2,2);
        doThrow(NullPointerException.class).when(systemUnderTest).playRound();
        //when
        systemUnderTest.playRound();
        //then
        verify(systemUnderTest, times(2)).playRound();
    }


    @Test
    void givenUserPickAndHeroWithNotEnoughMP_whenPlayRound_thenMyHeroCantUseDefensiveSkills() {        //given
        systemUnderTest.setDuelMenuChooser(menuChooserMock);
        systemUnderTest.setEnemy(enemyMock);
        systemUnderTest.setMyHero(myHeroMock);
        enemyMock = new Enemy("does not matter", new Stats(15, 20, 10, 150, 1, 10, 60, 10, 1));
        myHeroMock = new Warrior("does not matter");
        myHeroMock.getDuelStats().setMp(0);
        when(menuChooserMock.userPick()).thenReturn(3,3);
        doThrow(NullPointerException.class).when(systemUnderTest).playRound();
        //when
        systemUnderTest.playRound();
        //then
        verify(systemUnderTest, times(2)).playRound();
    }
    @Test
    void givenUserPickAndHeroAndEnemyAndEnoughMana_whenPlayRound_thenMyHeroCanUseDefensiveSkills() {
        //given
        systemUnderTest.setDuelMenuChooser(menuChooserMock);
        systemUnderTest.setEnemy(enemyMock);
        systemUnderTest.setMyHero(myHeroMock);
        enemyMock = new Enemy("does not matter", new Stats(15, 20, 10, 150, 1, 10, 60, 10, 1));
        myHeroMock = new Warrior("does not matter");
        when(menuChooserMock.userPick()).thenReturn(2);
        //when
        systemUnderTest.playRound();
        //then
        verify(defensiveRoundMock).defensiveSkills();
        verify(offensiveRoundMock).enemyAttack();
    }
    @Test
    void givenUserPickAndHeroAndEnemywhenPlayRound_thenMyHeroCanUseRest() {
        //given
        systemUnderTest.setDuelMenuChooser(menuChooserMock);
        systemUnderTest.setEnemy(enemyMock);
        systemUnderTest.setMyHero(myHeroMock);
        enemyMock = new Enemy("does not matter", new Stats(15, 20, 10, 150, 1, 10, 60, 10, 1));
        myHeroMock = new Warrior("does not matter");
        when(menuChooserMock.userPick()).thenReturn(4);
        //when
        systemUnderTest.playRound();
        //then
        verify(defensiveRoundMock).rest();
        verify(offensiveRoundMock).enemyAttack();
    }
}