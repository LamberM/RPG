package org.LamberM.enemy;

import org.LamberM.UnitTest;
import org.LamberM.classes.MyClass;
import org.LamberM.game.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class EnemyTest implements UnitTest
{
    @InjectMocks
    Enemy systemUnderTest;
    @Mock
    MyClass hero;
    @Mock
    Game game;
    @Test
    void duelStatsTest()
    {
        // given
        int expectedHP= systemUnderTest.enemyStats.getDuelHP();
        int expectedMP= systemUnderTest.enemyStats.getMp();
        // when
        systemUnderTest.duelStats();
        // then
        Assertions.assertEquals(expectedHP, systemUnderTest.enemyDuelStats.getDuelHP());
        Assertions.assertEquals(expectedMP, systemUnderTest.enemyDuelStats.getMp());
    }
    @Test
    void attackTest()
    {
        // given
        game.setRange(1);
        int extendedHp = hero.duelStats.getDuelHP() - systemUnderTest.enemyDuelStats.getDamage();
        // when
        systemUnderTest.attack();
        // then
        Assertions.assertEquals(extendedHp,hero.duelStats.getDuelHP());
    }
    @Test
    void stepForwardTest()
    {
        // given
        int expectedRange=2;
        // when
        systemUnderTest.attack();
        // then
        Assertions.assertEquals(expectedRange, systemUnderTest.game.getRange());
    }
}