package org.LamberM.stats;

import org.LamberM.UnitTest;
import org.LamberM.character.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

class StatsShowerTest implements UnitTest {
    @InjectMocks
    StatsShower systemUnderTest;

    @Test
    void givenListAndWarriorClass_whenShowStats_thenShowWarriorStats() {
        //given
        String expected = (
                "Stats:"+
                "\nStrength: 20"+
                "\nDexterity: 15"+
                "\nIntelligence: 10"+
                "\nHP: 200"+
                "\nMP: 40"+
                "\nDodge: 5"+
                "\nArmor: 100"+
                "\nCritical attack chance: 5"
        );
        //when
        systemUnderTest.showStats(Warrior.warriorDefaultStats());
        //then
        Assertions.assertEquals(expected.toString(), systemUnderTest.showStats(Warrior.warriorDefaultStats()).toString());
    }

}