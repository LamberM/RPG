package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.classes.Classes;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

public class GameTest implements UnitTest
{
    @InjectMocks
    Game gametest = new Game();
    @Test
    void addNameTest()
    {
        // given
        String userInput = "test";
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        // when
        gametest.addName();
        String expectedName= gametest.getName();
        // then
        assertEquals(expectedName,userInput);

    }

}