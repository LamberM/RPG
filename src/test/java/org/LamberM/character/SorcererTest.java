package org.LamberM.character;

import org.LamberM.UnitTest;
import org.LamberM.utils.OutputWriter;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorcererTest implements UnitTest {
    @InjectMocks
    Sorcerer systemUnderTest;
    @Mock
    OutputWriter outputWriterMock;
    ///////////////////////attack skills tests/////////////////////////////////
    @Test
    void givenSnowBall_whenProvideOffensiveSkills_thenUseSnowBall() {
        //given
        //when
        systemUnderTest.provideOffensiveSkills().get(1);
        //then
        int expected = 35;
    }


    @Test
    void givenUserPickFireBall_whenOffensiveSkillsMenu_thenUseFireBall() {
        //given
        //when
        systemUnderTest.provideOffensiveSkills().get(2);
        //then
        int expected = 35;
    }

    ////////////////////////////defensive skills tests///////////////////////////////////////

    @Test
    void givenUserPickFrostArmor_whenDefensiveSkillsMenu_thenFrostArmor() {
        // given
        int expectedArmor = systemUnderTest.getDuelStats().getArmor() + 10;
        int expectedMp = systemUnderTest.getDuelStats().getMp() - 20;
        //when
        systemUnderTest.provideDefensiveSkills().get(1);
        //then
        assertEquals(expectedArmor, systemUnderTest.getDuelStats().getArmor());
        assertEquals(expectedMp, systemUnderTest.getDuelStats().getMp());
    }

}