package org.LamberM.game;

import org.LamberM.UnitTest;

import org.LamberM.character.Character;
import org.LamberM.character.Warrior;
import org.LamberM.utils.InputReader;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.SystemOutWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.mockito.Mockito.when;

class HeroCreatorTest implements UnitTest {

    @InjectMocks
    HeroCreator systemUnderTest;
    @Mock
    InputReader inputReaderMock;
    @Mock
    MenuChooser menuChooserMock;
    @Mock
    SystemOutWriter systemOutWriterMock;

    @Test
    void givenExpectedClassInputReaderAndUserPick_whenCreateHero_thenCreateNewHeroWithName() {
        //given
        when(inputReaderMock.read()).thenReturn("test");
        when(menuChooserMock.userPick()).thenReturn(1);
        //when
        Character result = systemUnderTest.createHero();
        //then
        Warrior expectedClass = new Warrior("test");
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result instanceof Warrior);
        Assertions.assertEquals("test", expectedClass.getName());
    }

    @Test
    void givenInvalidValue_whenCreateHero_thenThrowIllegalArgumentException() {
        //given
        when(inputReaderMock.read()).thenReturn("test");
        when(menuChooserMock.userPick()).thenReturn(4);
        //when
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> systemUnderTest.createHero());
        //then
        String expectedMessage = "Should never happen, because user must correct pick";
        Assertions.assertTrue(expectedMessage.contains(illegalArgumentException.getMessage()));
    }
}