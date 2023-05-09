package org.LamberM.character;

import org.LamberM.UnitTest;
import org.LamberM.utils.OutputWriter;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarriorTest implements UnitTest {
    @InjectMocks
    Warrior systemUnderTest;
    @Mock
    OutputWriter outputWriterMock;

    @Test
    void givenUserPickDoubleAttack_whenOffensiveSkillsMenu_thenDoubleAttack() {
        //given
        //when
        systemUnderTest.provideOffensiveSkills().get(1);
        //then
        int expected = 64;
    }
    @Test
    void givenUserPickBattleCry_whenDefensiveSkillsMenu_thenBattleCry() {
        // given
        //when
        systemUnderTest.provideDefensiveSkills().get(1);
        //then
        int expectedStr = systemUnderTest.getDuelStats().getStrength() + 10;
        int expectedArmor = systemUnderTest.getDuelStats().getArmor() + 5;
        int expectedCritC = systemUnderTest.getDuelStats().getCriticalChance() + 2;
        int expectedMp = systemUnderTest.getDuelStats().getMp() - 20;
        assertEquals(expectedStr, systemUnderTest.getDuelStats().getStrength());
        assertEquals(expectedArmor, systemUnderTest.getDuelStats().getArmor());
        assertEquals(expectedCritC, systemUnderTest.getDuelStats().getCriticalChance());
        assertEquals(expectedMp, systemUnderTest.getDuelStats().getMp());
    }

    @Test
    void defensiveCryTest() {
        // given
        //when
        systemUnderTest.provideDefensiveSkills().get(2);
        //then
        int expectedHp = systemUnderTest.getDuelStats().getHp() + 20;
        int expectedArmor = systemUnderTest.getDuelStats().getArmor() + 10;
        int expectedDodge = systemUnderTest.getDuelStats().getDodge() + 2;
        int expectedMp = systemUnderTest.getDuelStats().getMp() - 20;
        assertEquals(expectedHp, systemUnderTest.getDuelStats().getHp());
        assertEquals(expectedArmor, systemUnderTest.getDuelStats().getArmor());
        assertEquals(expectedDodge, systemUnderTest.getDuelStats().getDodge());
        assertEquals(expectedMp, systemUnderTest.getDuelStats().getMp());
    }

}