package org.LamberM.game;

import org.LamberM.UnitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;


class LevelTest implements UnitTest {
    @InjectMocks
    Level systemUnderTest;
    @Test
    void dontGetLvlUp()
    {
        //given
        systemUnderTest.setLvl(90);
        systemUnderTest.setLvlToCompare(91);
        //when
        //then
        Assertions.assertEquals(false,systemUnderTest.getLvlUp());
    }
    @Test
    void getLvlUp()
    {
        //given
        systemUnderTest.setLvl(90);
        systemUnderTest.setLvlToCompare(90);
        //when
        //then
        Assertions.assertEquals(true,systemUnderTest.getLvlUp());
    }
    @Test
    void lvlUPtest(){
        //given
        systemUnderTest.setExp(120);
        int expectedLevel = 2;
        int expectedExp = 20;
        //when
        systemUnderTest.lvlUP();
        //then
        Assertions.assertEquals(expectedLevel,systemUnderTest.getLvl());
        Assertions.assertEquals(expectedExp,systemUnderTest.getExp());
    }
    @Test
    void expNotNegative(){
        //given
        systemUnderTest.setExp(-100);
        int expected = 0;
        //when
        systemUnderTest.lvlUP();
        //then
        int actual = systemUnderTest.getExp();
        System.out.println(actual);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void addExpTest(){
        //given
        //when
        systemUnderTest.addExp();
        //then
        int actual = systemUnderTest.getExp();
        System.out.println(actual);
        Assertions.assertNotEquals(69,actual);
    }


}