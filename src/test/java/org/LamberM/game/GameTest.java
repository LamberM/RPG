package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.classes.Assassin;
import org.LamberM.classes.Classes;
import org.LamberM.classes.Sorcerer;
import org.LamberM.classes.Warrior;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

public class GameTest implements UnitTest
{
    @InjectMocks
    Game gametest = new Game();
    @Mock
    Warrior warriorTest=new Warrior();
    @Mock
    Assassin assassinTest= new Assassin();
    @Mock
    Sorcerer sorcererTest= new Sorcerer();
    @Mock
    Classes myHero = new Sorcerer(); // pick random class

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
    @Test
    void infoAboutClassTest()
    {
        //given
        //when
        gametest.infoAboutClass();
        //then
        assert warriorTest !=null;
        assert assassinTest !=null;
        assert sorcererTest !=null;
    }
    @Test
    void mainMenuFightTest ()
    {

        //given
        String userInputName = "test";
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInputName.getBytes());
        System.setIn(transferToByte);
        gametest.addName();
        assassinTest.setUserChoice(1); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassinTest.getUserChoice());
        transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //when
        gametest.mainMenu();
        //then

    }
    @Test
    void mainMenuLookAtStatsTest ()
    {
        // repair duelStats

        //given
        String userInputName = "test";
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInputName.getBytes());
        System.setIn(transferToByte);
        gametest.addName();
        assassinTest.setUserChoice(2); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassinTest.getUserChoice());
        transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //when
        gametest.mainMenu();
        //then

    }
    @Test
    void mainMenuAddStatsTest ()
    {
        //given
        String userInputName = "test";
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInputName.getBytes());
        System.setIn(transferToByte);
        gametest.addName();
        assassinTest.setUserChoice(2); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassinTest.getUserChoice());
        transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //when
        gametest.mainMenu();
        //then

    }
    @Test
    void mainMenuExitTest ()
    {
        //given
        String userInputName = "test";
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInputName.getBytes());
        System.setIn(transferToByte);
        gametest.addName();
        assassinTest.setUserChoice(4); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassinTest.getUserChoice());
        transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //when
        gametest.mainMenu();
        //then

    }
    @Test
    void duelMenuAttackTest()
    {
        //given

        //when
        assassinTest.setUserChoice(1); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassinTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //then
    }
    @Test
    void duelMenuSkillsTest()
    {
        //given

        //when
        assassinTest.setUserChoice(2); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassinTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //then
    }
    @Test
    void duelMenuStepTest()
    {
        //given

        //when
        assassinTest.setUserChoice(3); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassinTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //then
    }
    @Test
    void duelMenuRestTest()
    {
        //given

        //when
        assassinTest.setUserChoice(4); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassinTest.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //then
    }

}