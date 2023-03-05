package org.LamberM.stats;

import org.LamberM.UnitTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatsTest implements UnitTest
{
    @InjectMocks
    private Stats statsTest = new Stats(1,1,1,1,1,1,1,1,1);
        @Test
        void addStrengthTest()
        {
            // given
            statsTest.setLvl(2); // give us possibility to use addStats (requirement is done)
            statsTest.setUserChoice(1); // give us possibility to change our scanner in application
            String userInput = String.valueOf(statsTest.getUserChoice());
            ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
            System.setIn(transferToByte);
            int expectedStr = statsTest.getStrength()+5;
            // when
            statsTest.addStats();
            // then
            assertEquals(expectedStr,statsTest.getStrength());
        }
        @Test
        void addDexterityTest()
        {
            // given
            statsTest.setLvl(2); // give us possibility to use addStats (requirement is done)
            statsTest.setUserChoice(2); // give us possibility to change our scanner in application
            String userInput = String.valueOf(statsTest.getUserChoice());
            ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
            System.setIn(transferToByte);
            int expectedDex = statsTest.getDexterity()+5;
            // when
            statsTest.addStats();
            // then
            assertEquals(expectedDex,statsTest.getDexterity());
        }
        @Test
        void addIntelligenceTest()
        {
            // given
            statsTest.setLvl(2); // give us possibility to use addStats (requirement is done)
            statsTest.setUserChoice(3); // give us possibility to change our scanner in application
            String userInput = String.valueOf(statsTest.getUserChoice());
            ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
            System.setIn(transferToByte);
            int expectedInt = statsTest.getIntelligence()+5;
            // when
            statsTest.addStats();
            // then
            assertEquals(expectedInt,statsTest.getIntelligence());
        }
        @Test
        void showStatsTest()
        {
            // given
            int expectedValueOfAllStats=1;
            // when
            statsTest.showStats();
            // then
            assertEquals(expectedValueOfAllStats,statsTest.getStrength());
            assertEquals(expectedValueOfAllStats,statsTest.getDexterity());
            assertEquals(expectedValueOfAllStats,statsTest.getIntelligence());
            assertEquals(expectedValueOfAllStats,statsTest.getHp());
            assertEquals(expectedValueOfAllStats,statsTest.getMp());
            assertEquals(expectedValueOfAllStats,statsTest.getDodge());
            assertEquals(expectedValueOfAllStats,statsTest.getArmor());
            assertEquals(expectedValueOfAllStats,statsTest.getCriticalChance());
            assertEquals(expectedValueOfAllStats,statsTest.getAttackRange());
        }
        @Test
    void dualStatsTest()
        {
            //given
            int expectedValueOfAllStats=1;
            //when
            statsTest.duelStats();
            //then
            assertEquals(expectedValueOfAllStats,statsTest.getDuelHP());
            assertEquals(expectedValueOfAllStats,statsTest.getDuelMP());
        }

}