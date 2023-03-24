package org.LamberM.stats;

import org.LamberM.UnitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StatsTest implements UnitTest
{

        @Test
        void correctValues()
        {
            //given
            int expected= 1;
            //when
            Stats systemUnderTest = new Stats(1,1,1,1,1,1,1,1,1);
            // then
            Assertions.assertEquals(expected,systemUnderTest.getStrength());
            Assertions.assertEquals(expected,systemUnderTest.getDexterity());
            Assertions.assertEquals(expected,systemUnderTest.getIntelligence());
            Assertions.assertEquals(expected,systemUnderTest.getHp());
            Assertions.assertEquals(expected,systemUnderTest.getMp());
            Assertions.assertEquals(expected,systemUnderTest.getDodge());
            Assertions.assertEquals(expected,systemUnderTest.getArmor());
            Assertions.assertEquals(expected,systemUnderTest.getCriticalChance());
            Assertions.assertEquals(expected,systemUnderTest.getAttackRange());
        }
//        @Test
//        void illegalArgumentException()
//        {
//            //given
//            Stats systemUnderTest;
//            //when
//            systemUnderTest = new Stats(1,1,1,1,1,1,1,1,1);
//            //then
////            Assertions.assertEquals(IllegalArgumentException.class, systemUnderTest = new Stats(-1,1,1,1,1,1,1,1,1));
//        }


}