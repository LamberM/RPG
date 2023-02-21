package org.LamberM.stats;

import org.LamberM.UnitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class DuelStatsTest implements UnitTest {
    @Mock
    private Stats statsTest = new Stats(1,1,1,100,10,1,1,1,1);
    @InjectMocks
    private DuelStats duelStatsTest = new DuelStats();
    @Test
    void DuelStatsTest()
    {
        //given
        //when
        int expectedHP=100;
        int expectedMP=10;
        duelStatsTest.duelStats();
        //then
        Assertions.assertEquals(expectedHP,duelStatsTest.getCurrentHP());
        Assertions.assertEquals(expectedMP,duelStatsTest.getCurrentMP());
    }
}
