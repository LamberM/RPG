package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.characters.Assassin;
import org.LamberM.characters.Sorcerer;
import org.LamberM.characters.Warrior;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest implements UnitTest
{

    @InjectMocks
    Game systemUnderTest;
    @Mock
    Warrior warrior;
    @Mock
    Assassin assassin;
    @Mock
    Sorcerer sorcerer;
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
        systemUnderTest.addName();
        String expectedName= systemUnderTest.getName();
        // then
        assertEquals(expectedName,userInput);

    }
    @Test
    void infoAboutClassTest()
    {
        //given
        //when
        systemUnderTest.infoAboutClass();
        //then
        assert warrior !=null;
        assert assassin !=null;
        assert sorcerer !=null;
    }
    @Test
    void mainMenuFightTest ()
    {

        //given
        String userInputName = "test";
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInputName.getBytes());
        System.setIn(transferToByte);
        systemUnderTest.addName();
        assassin.setUserChoice(1); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassin.getUserChoice());
        transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //when
        systemUnderTest.mainMenu();
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
        systemUnderTest.addName();
        assassin.setUserChoice(2); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassin.getUserChoice());
        transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //when
        systemUnderTest.mainMenu();
        //then

    }
    @Test
    void mainMenuAddStatsTest ()
    {
        //given
        String userInputName = "test";
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInputName.getBytes());
        System.setIn(transferToByte);
        systemUnderTest.addName();
        assassin.setUserChoice(2); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassin.getUserChoice());
        transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //when
        systemUnderTest.mainMenu();
        //then

    }
    @Test
    void mainMenuExitTest ()
    {
        //given
        String userInputName = "test";
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInputName.getBytes());
        System.setIn(transferToByte);
        systemUnderTest.addName();
        assassin.setUserChoice(4); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassin.getUserChoice());
        transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //when
        systemUnderTest.mainMenu();
        //then

    }
    @Test
    void duelMenuAttackTest()
    {
        //given

        //when
        assassin.setUserChoice(1); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassin.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //then
    }
    @Test
    void duelMenuSkillsTest()
    {
        //given

        //when
        assassin.setUserChoice(2); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassin.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //then
    }
    @Test
    void duelMenuStepTest()
    {
        //given

        //when
        assassin.setUserChoice(3); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassin.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //then
    }
    @Test
    void duelMenuRestTest()
    {
        //given

        //when
        assassin.setUserChoice(4); // give us possibility to change our scanner in application
        String userInput = String.valueOf(assassin.getUserChoice());
        ByteArrayInputStream transferToByte = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(transferToByte);
        //then
    }

}