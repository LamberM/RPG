package org.LamberM.character;

import org.LamberM.UnitTest;
import org.LamberM.utils.OutputWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


class AssassinTest implements UnitTest {

    @InjectMocks
    Assassin systemUnderTest;
    @Mock
    OutputWriter outputWriterMock;

    @Test
    void givenUserPickCriticalAttackSkill_whenOffensiveSkillsMenu_thenCriticalAttackSkill() {
        //given
        //when
        systemUnderTest.provideOffensiveSkills().get(1);
        //then
        int expected = 34;
    }

    @Test
    void givenUserPickHitInTheBack_whenOffensiveSkillsMenu_thenHitInTheBack() {
        //given
        //when
        systemUnderTest.provideOffensiveSkills().get(2);
        //then
        int expected = 34;
    }

    @Test
    void givenUserPickBoostDodgeAndDexterity_whenDefensiveSkillsMenu_thenBoostDodgeAndDexterity() {
        //given
        int expectedDex = systemUnderTest.getDuelStats().getDexterity() + 10;
        int expectedDodge = systemUnderTest.getDuelStats().getDodge() + 5;
        int expectedCritC = systemUnderTest.getDuelStats().getCriticalChance() + 5;
        int expectedMp = systemUnderTest.getDuelStats().getMp() - 20;
        //when
        systemUnderTest.provideDefensiveSkills().get(1);
        //then
        Assertions.assertEquals(expectedDex, systemUnderTest.getDuelStats().getDexterity());
        Assertions.assertEquals(expectedDodge, systemUnderTest.getDuelStats().getDodge());
        Assertions.assertEquals(expectedCritC, systemUnderTest.getDuelStats().getCriticalChance());
        Assertions.assertEquals(expectedMp, systemUnderTest.getDuelStats().getMp());
    }

}