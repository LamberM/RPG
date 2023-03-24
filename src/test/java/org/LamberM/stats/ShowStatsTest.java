package org.LamberM.stats;

import org.LamberM.UnitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShowStatsTest implements UnitTest {
    @InjectMocks
    ShowStats systemUnderTest;
    @Test
    void showStatsTest(){
        //given
        List<Object> expected = List.of(
                "All class stats:",
                "My hero stats:",
                "Strength: 20",
                "Dexterity: 15",
                "Intelligence: 10",
                "HP: 200",
                "MP: 40",
                "Dodge: 5",
                "Armor: 100",
                "Critical attack chance: 5"
        );
        //when
        systemUnderTest.showStats();
        //then
        Assertions.assertEquals(expected.toString(),systemUnderTest.showStats().toString());
    }

}