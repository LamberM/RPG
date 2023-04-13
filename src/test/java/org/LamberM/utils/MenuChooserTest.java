package org.LamberM.utils;

import org.LamberM.UnitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.when;

class MenuChooserTest implements UnitTest {
    @InjectMocks
    MenuChooser systemUnderTest;
    @Mock
    InputReader inputReaderMock;
    @Mock
    List<String> menuMock;

    @Test
    void givenEmptyList_when_thenIllegalArgumentException() {
        //given
        menuMock = List.of();
        inputReaderMock = Mockito.mock(SystemInReader.class);
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> systemUnderTest = new MenuChooser(inputReaderMock, menuMock));
    }

    @Test
    void givenListAndRead_whenUserPick_thenUserPickDoNotWork() {
        //given
        String expectedMessage = "You made mistakes too much";
        menuMock = List.of(
                "test1",
                "test2",
                "test3"
        );
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("0", "-1", "-2", "-3", "-1");
        systemUnderTest = new MenuChooser(inputReaderMock, menuMock);
        //when
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> systemUnderTest.userPick());
        //then
        Assertions.assertTrue(expectedMessage.contains(illegalArgumentException.getMessage()));

    }

    @Test
    void givenListAndRead_whenUserPick_thenUserPickWork() {
        //given
        List<String> menu = List.of(
                "test1",
                "test2",
                "test3"
        );
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("0", "1");
        systemUnderTest = new MenuChooser(inputReaderMock, menu);
        int expectedValue = 1;
        //when
        systemUnderTest.userPick();
        int actualUserPick = systemUnderTest.userPick();
        //then
        Assertions.assertEquals(expectedValue, actualUserPick);

    }
}