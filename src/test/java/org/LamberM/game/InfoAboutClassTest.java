package org.LamberM.game;

import org.LamberM.UnitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

class InfoAboutClassTest implements UnitTest {
    @InjectMocks
    InfoAboutClass systemUnderTest;
    @Test
    void infoAboutClassTest() {
        //given
        List<Object> expected = List.of(
                "All class stats:",
                "Warrior stats:",
                "Strength: 20",
                "Dexterity: 15",
                "Intelligence: 10",
                "HP: 200",
                "MP: 40",
                "Dodge: 5",
                "Armor: 100",
                "Critical attack chance: 5",
                "Assassin stats:",
                "Strength: 15",
                "Dexterity: 20",
                "Intelligence: 10",
                "HP: 150",
                "MP: 40",
                "Dodge: 10",
                "Armor: 60",
                "Critical attack chance: 10",
                "Sorcerer stats:",
                "Strength: 5",
                "Dexterity: 15",
                "Intelligence: 25",
                "HP: 120",
                "MP: 80",
                "Dodge: 5",
                "Armor: 40",
                "Critical attack chance: 5"
        );
        //when
        systemUnderTest.infoAboutClass();
        //then
        Assertions.assertEquals(expected.toString(),systemUnderTest.infoAboutClass().toString());
    }

}