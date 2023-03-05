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
    Enemy enemyTest = new Enemy();
    @Mock
    MyClass hero = new MyClass();
    @Mock
    Game game = new Game();
    @Test
    void duelStatsTest()
    {
        // given
        int expectedHP=enemyTest.enemyStats.getDuelHP();
        int expectedMP=enemyTest.enemyStats.getMp();
        // when
        enemyTest.duelStats();
        // then
        Assertions.assertEquals(expectedHP,enemyTest.enemyDuelStats.getDuelHP());
        Assertions.assertEquals(expectedMP,enemyTest.enemyDuelStats.getMp());
    }
    @Test
    void attackTest()
    {
        // given
        game.setRange(1);
        int extendedHp = hero.duelStats.getDuelHP() - enemyTest.enemyDuelStats.getDamage();
        // when
        enemyTest.attack();
        // then
        Assertions.assertEquals(extendedHp,hero.duelStats.getDuelHP());
    }
    @Test
    void stepForwardTest()
    {
        // given
        int expectedRange=2;
        // when
        enemyTest.attack();
        // then
        Assertions.assertEquals(expectedRange,enemyTest.game.getRange());
    }
}