package org.LamberM.enemy;

import org.LamberM.UnitTest;
import org.LamberM.classes.MyClass;
import org.LamberM.game.Game;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        // when
        int expectedHP=enemyTest.enemyStats.getHp();
        int expectedMP=enemyTest.enemyStats.getMp();
        enemyTest.duelStats();
        // then
        assertEquals(expectedHP,enemyTest.enemyDuelStats.getHp());
        assertEquals(expectedMP,enemyTest.enemyDuelStats.getMp());
    }
    @Test
    void attackTest()
    {
        // given

        // when
        game.setRange(1);
        enemyTest.attack();
        int extendedHp = hero.duelStats.getHp() - enemyTest.enemyDuelStats.getDamage();
        // then
        assertEquals(extendedHp,hero.duelStats.getHp());
    }
    @Test
    void stepForwardTest()
    {
        // given

        // when
        int expectedRange=2;
        enemyTest.attack();
        // then
        assertEquals(expectedRange,game.getRange());
    }
}