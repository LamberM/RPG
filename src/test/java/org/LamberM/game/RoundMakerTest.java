package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.character.Enemy;
import org.LamberM.character.Warrior;
import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemOutWriter;
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
    @Mock
    SystemOutWriter systemOutWriterMock;
    @Test
    void givenUserPickAndHeroAndEnemyAndEnoughRange_whenPlayRound_thenMyHeroAndEnemyTryAttack() {
        //given
        systemUnderTest.setRange(1);
        Stats statsMock = mock(Stats.class);
        Enemy enemyMock = mock(Enemy.class);
        when(enemyMock.getDuelStats()).thenReturn(statsMock);
        Warrior myHeroMock = mock(Warrior.class);
        when(myHeroMock.getDuelStats()).thenReturn(statsMock);
        when(menuChooserMock.userPick()).thenReturn(1);
        //when
        systemUnderTest.playRound(myHeroMock,enemyMock);
        //then
        verify(offensiveRoundMakerMock).attack(myHeroMock,enemyMock);
        verify(offensiveRoundMakerMock).attack(enemyMock,myHeroMock);
    }

    @Test
    void givenUserPickAndHero_whenPlayRound_thenMyHeroCantAttack() {
        //given
        systemUnderTest.setRange(5);
        Stats statsMock = mock(Stats.class);
        Enemy enemyMock = mock(Enemy.class);
        when(enemyMock.getDuelStats()).thenReturn(statsMock);
        Warrior myHeroMock = mock(Warrior.class);
        when(myHeroMock.getDuelStats()).thenReturn(statsMock);
        when(menuChooserMock.userPick()).thenReturn(1);
        //when
        systemUnderTest.playRound(myHeroMock,enemyMock);
        //then
        verify(offensiveRoundMakerMock,times(0)).attack(myHeroMock,enemyMock);
    }

    @Test
    void givenUserPickAndHeroAndEnemyAndEnoughRange_whenPlayRound_thenMyHeroCanUseOffensiveSkills() {
        //given
        systemUnderTest.setRange(1);
        Stats statsMock = mock(Stats.class);
        Enemy enemyMock = mock(Enemy.class);
        when(enemyMock.getDuelStats()).thenReturn(statsMock);
        Warrior myHeroMock = mock(Warrior.class);
        when(myHeroMock.getDuelStats()).thenReturn(statsMock);
        when(menuChooserMock.userPick()).thenReturn(2);
        //when
        systemUnderTest.playRound(myHeroMock,enemyMock);
        //then
        verify(offensiveRoundMakerMock).offensiveSkills(myHeroMock,enemyMock);
    }

    @Test
    void givenUserPickAndHeroWithNotEnoughMP_whenPlayRound_thenMyHeroCantUseOffensiveSkills() {
        //given
        Stats statsMock = mock(Stats.class);
        Enemy enemyMock = mock(Enemy.class);
        when(enemyMock.getDuelStats()).thenReturn(statsMock);
        Warrior myHeroMock = mock(Warrior.class);
        when(myHeroMock.getDuelStats()).thenReturn(statsMock);
        systemUnderTest.setRange(1);
        myHeroMock.getDuelStats().setMp(0);
        when(menuChooserMock.userPick()).thenReturn(2);
        //when
        systemUnderTest.playRound(myHeroMock,enemyMock);
        //then
        verify(offensiveRoundMakerMock).offensiveSkills(myHeroMock,enemyMock);
    }

    @Test
    void givenUserPickAndHeroAndNotEnoughRange_whenPlayRound_thenMyHeroCantUseOffensiveSkills() {
        //given
        Stats statsMock = mock(Stats.class);
        Enemy enemyMock = mock(Enemy.class);
        when(enemyMock.getDuelStats()).thenReturn(statsMock);
        Warrior myHeroMock = mock(Warrior.class);
        when(myHeroMock.getDuelStats()).thenReturn(statsMock);
        systemUnderTest.setRange(5);
        when(menuChooserMock.userPick()).thenReturn(2);
        //when
        systemUnderTest.playRound(myHeroMock,enemyMock);
        //then
        verify(offensiveRoundMakerMock).offensiveSkills(myHeroMock,enemyMock);
    }


    @Test
    void givenUserPickAndHeroWithNotEnoughMP_whenPlayRound_thenMyHeroCantUseDefensiveSkills() {
        //given
        Stats statsMock = mock(Stats.class);
        Enemy enemyMock = mock(Enemy.class);
        when(enemyMock.getDuelStats()).thenReturn(statsMock);
        Warrior myHeroMock = mock(Warrior.class);
        when(myHeroMock.getDuelStats()).thenReturn(statsMock);
        systemUnderTest.setRange(1);
        myHeroMock.getDuelStats().setMp(0);
        when(menuChooserMock.userPick()).thenReturn(3,3);
        //when
        systemUnderTest.playRound(myHeroMock,enemyMock);
        //then
        verify(defensiveRoundMakerMock).defensiveSkills(myHeroMock);
    }
    @Test
    void givenUserPickAndHeroAndEnemyAndEnoughMana_whenPlayRound_thenMyHeroCanUseDefensiveSkills() {
        //given
        Stats statsMock = mock(Stats.class);
        Enemy enemyMock = mock(Enemy.class);
        when(enemyMock.getDuelStats()).thenReturn(statsMock);
        Warrior myHeroMock = mock(Warrior.class);
        when(myHeroMock.getDuelStats()).thenReturn(statsMock);
        when(menuChooserMock.userPick()).thenReturn(3);
        //when
        systemUnderTest.playRound(myHeroMock,enemyMock);
        //then
        verify(defensiveRoundMakerMock).defensiveSkills(myHeroMock);
    }
    @Test
    void givenUserPickAndHeroAndEnemywhenPlayRound_thenMyHeroCanUseRest() {
        //given
        Stats statsMock = mock(Stats.class);
        Enemy enemyMock = mock(Enemy.class);
        when(enemyMock.getDuelStats()).thenReturn(statsMock);
        Warrior myHeroMock = mock(Warrior.class);
        when(myHeroMock.getDuelStats()).thenReturn(statsMock);
        when(menuChooserMock.userPick()).thenReturn(5);
        //when
        systemUnderTest.playRound(myHeroMock,enemyMock);
        //then
        verify(defensiveRoundMakerMock).rest(myHeroMock);
    }
}