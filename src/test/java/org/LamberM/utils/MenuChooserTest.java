package org.LamberM.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.when;

class MenuChooserTest {
    @InjectMocks
    MenuChooser systemUnderTest;
    @Mock
    InputReader inputReaderMock;
    @Test
    void menuIsEmptyTest()
    {
        //given
        List<String> menu = List.of();
        inputReaderMock = Mockito.mock(SystemInReader.class);
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> systemUnderTest= new MenuChooser(inputReaderMock,menu));
    }
    @Test
    void wrongRequiredValueTest ()
    {
        //given
        List<String> menu = List.of(
                "test1",
                "test2",
                "test3"
        );
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("0","-1","-2","-3","-1");
        systemUnderTest = new MenuChooser(inputReaderMock,menu);
        int expectedValue=-1;
        //when
        int actualUserPick =systemUnderTest.userPick();
        //then
        Assertions.assertEquals(expectedValue,actualUserPick);

    }
    @Test
    void rightRequiredValueTest ()
    {
        //given
        List<String> menu = List.of(
                "test1",
                "test2",
                "test3"
        );
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("0","1");
        systemUnderTest = new MenuChooser(inputReaderMock,menu);
        int expectedValue=1;
        //when
        systemUnderTest.userPick();
        int actualUserPick =systemUnderTest.userPick();
        //then
        Assertions.assertEquals(expectedValue,actualUserPick);

    }
}