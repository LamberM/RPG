package org.LamberM.stats;

import org.LamberM.UnitTest;
import org.LamberM.character.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShowStatsTest implements UnitTest {
    @InjectMocks
    ShowStats systemUnderTest;

    @Test
    void givenListAndWarriorClass_whenShowStats_thenShowWarriorStats() {
        //given
        List<Object> expected = List.of(
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
        Warrior warrior = new Warrior("does not matter in test");
        //when
        systemUnderTest.showStats(warrior);
        //then
        Assertions.assertEquals(expected.toString(), systemUnderTest.showStats(warrior).toString());
    }

}