package org.LamberM.game;

import org.LamberM.UnitTest;

import org.LamberM.character.Character;
import org.LamberM.character.Warrior;
import org.LamberM.utils.InputReader;
import org.LamberM.utils.MenuChooser;
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

    @Test
    void givenExpectedClassInputReaderAndUserPick_whenCreateHero_givenCreateNewHeroWithName() {
        //given
        Warrior expectedClass = new Warrior("test");
        systemUnderTest.setClassMenuChooser(menuChooserMock);
        systemUnderTest.setInputReader(inputReaderMock);
        when(inputReaderMock.read()).thenReturn("test");
        when(menuChooserMock.userPick()).thenReturn(1);
        //when
        Character result = systemUnderTest.createHero();
        //then
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result instanceof Warrior);
        Assertions.assertEquals("test", expectedClass.getName());
    }

    @Test
    void givenInvalidValue_whenCreateHero_thenThrowIllegalArgumentException() {
        //given
        String expectedMessage = "Should never happen";
        systemUnderTest.setClassMenuChooser(menuChooserMock);
        systemUnderTest.setInputReader(inputReaderMock);
        when(inputReaderMock.read()).thenReturn("test");
        when(menuChooserMock.userPick()).thenReturn(4);
        //when
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> systemUnderTest.createHero());
        //then
        Assertions.assertTrue(expectedMessage.contains(illegalArgumentException.getMessage()));
    }
}