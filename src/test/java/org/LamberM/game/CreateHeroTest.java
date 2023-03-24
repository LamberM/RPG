package org.LamberM.game;

import org.LamberM.UnitTest;

import org.LamberM.utils.InputReader;
import org.LamberM.utils.SystemInReader;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.mockito.Mockito.when;

class CreateHeroTest implements UnitTest {

    @InjectMocks
    CreateHero systemUnderTest;
    @Mock
    InputReader inputReaderMock;

    @Test
    void addName() {
        //given
        inputReaderMock = Mockito.mock(SystemInReader.class);
        String expected = "test";
        when(inputReaderMock.read()).thenReturn(expected);
        //when
        systemUnderTest.addName();
        //then
        String actual = systemUnderTest.getName();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void getName() {
        //given
        systemUnderTest.setName("test");
        String expected= "test";
        //when
        String actual = systemUnderTest.getName();
        //then
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void pickWarrior() {
        //given
        inputReaderMock = Mockito.mock(SystemInReader.class);
        String expected = "You chose a warrior";
        when(inputReaderMock.read()).thenReturn("1");
        ByteArrayOutputStream actual = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actual));
        //when
        systemUnderTest.pickClass();
        //then
        Assertions.assertEquals(expected,actual.toString());
    }
    @Test
    void pickAssassin() {
        //given
        inputReaderMock = Mockito.mock(SystemInReader.class);
        String expected = "You chose a assassin";
        when(inputReaderMock.read()).thenReturn("2");
        ByteArrayOutputStream actual = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actual));
        //when
        systemUnderTest.pickClass();
        //then
        Assertions.assertEquals(expected,actual.toString());
    }
    @Test
    void pickSorcerer() {
        //given
        inputReaderMock = Mockito.mock(SystemInReader.class);
        String expected = "You chose a sorcerer";
        when(inputReaderMock.read()).thenReturn("3");
        ByteArrayOutputStream actual = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actual));
        //when
        systemUnderTest.pickClass();
        //then
        Assertions.assertEquals(expected,actual.toString());
    }
    @Test
    void exitTheGame() {
        //given
        inputReaderMock = Mockito.mock(SystemInReader.class);
        String expected = "See you later, bye";
        when(inputReaderMock.read()).thenReturn("4");
        ByteArrayOutputStream actual = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actual));
        //when
        systemUnderTest.pickClass();
        //then
        Assertions.assertEquals(expected,actual.toString());
    }

}