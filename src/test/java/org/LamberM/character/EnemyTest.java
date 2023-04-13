package org.LamberM.character;

import org.LamberM.UnitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;


class EnemyTest implements UnitTest {
    @InjectMocks
    Enemy systemUnderTest;

    @Test
    void attack() {
        //given
        int expected = 55;
        //when
        int actual = systemUnderTest.attack();
        //then
        Assertions.assertEquals(expected, actual);
    }
}