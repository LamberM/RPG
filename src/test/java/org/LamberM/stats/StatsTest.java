package org.LamberM.stats;

import org.LamberM.UnitTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatsTest implements UnitTest
{
    @InjectMocks
    private Stats systemUnderTest = new Stats(1,1,1,1,1,1,1,1,1);
        @Test
        void addStrengthTest()
        {
            // given
            systemUnderTest.setLvl(2); // give us possibility to use addStats (requirement is done)
            systemUnderTest.setUserChoice(1); // give us possibility to change our scanner in application
            String userInput = String.valueOf(systemUnderTest.getUserChoice());
            ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
            System.setIn(transferToByte);
            int expectedStr = systemUnderTest.getStrength()+5;
            // when
            systemUnderTest.addStats();
            // then
            assertEquals(expectedStr, systemUnderTest.getStrength());
        }
        @Test
        void addDexterityTest()
        {
            // given
            systemUnderTest.setLvl(2); // give us possibility to use addStats (requirement is done)
            systemUnderTest.setUserChoice(2); // give us possibility to change our scanner in application
            String userInput = String.valueOf(systemUnderTest.getUserChoice());
            ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
            System.setIn(transferToByte);
            int expectedDex = systemUnderTest.getDexterity()+5;
            // when
            systemUnderTest.addStats();
            // then
            assertEquals(expectedDex, systemUnderTest.getDexterity());
        }
        @Test
        void addIntelligenceTest()
        {
            // given
            systemUnderTest.setLvl(2); // give us possibility to use addStats (requirement is done)
            systemUnderTest.setUserChoice(3); // give us possibility to change our scanner in application
            String userInput = String.valueOf(systemUnderTest.getUserChoice());
            ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
            System.setIn(transferToByte);
            int expectedInt = systemUnderTest.getIntelligence()+5;
            // when
            systemUnderTest.addStats();
            // then
            assertEquals(expectedInt, systemUnderTest.getIntelligence());
        }
        @Test
        void showStatsTest()
        {
            // given
            int expectedValueOfAllStats=1;
            // when
            systemUnderTest.showStats();
            // then
            assertEquals(expectedValueOfAllStats, systemUnderTest.getStrength());
            assertEquals(expectedValueOfAllStats, systemUnderTest.getDexterity());
            assertEquals(expectedValueOfAllStats, systemUnderTest.getIntelligence());
            assertEquals(expectedValueOfAllStats, systemUnderTest.getHp());
            assertEquals(expectedValueOfAllStats, systemUnderTest.getMp());
            assertEquals(expectedValueOfAllStats, systemUnderTest.getDodge());
            assertEquals(expectedValueOfAllStats, systemUnderTest.getArmor());
            assertEquals(expectedValueOfAllStats, systemUnderTest.getCriticalChance());
            assertEquals(expectedValueOfAllStats, systemUnderTest.getAttackRange());
        }
        @Test
    void dualStatsTest()
        {
            //given
            int expectedValueOfAllStats=1;
            //when
            systemUnderTest.duelStats();
            //then
            assertEquals(expectedValueOfAllStats, systemUnderTest.getDuelHP());
            assertEquals(expectedValueOfAllStats, systemUnderTest.getDuelMP());
        }

}