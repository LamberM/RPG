package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.character.Warrior;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

class DefensiveRoundTest implements UnitTest {

    @InjectMocks
    DefensiveRound systemUnderTest;
    @Mock
    Warrior warriorMock;

    @Test
    void givenMyHeroMock_whenDefensiveSkillsMenu_thenUseDefensiveSkills() {
        //given
        //when
        systemUnderTest.defensiveSkills();
        //then
        verify(warriorMock).defensiveSkillsMenu();

    }

    @Test
    void givenMyHeroMock_whenDefensiveSkillsMenu_thenUseRest() {
        //given
        //when
        systemUnderTest.rest();
        //then
        verify(warriorMock).rest();
    }
}