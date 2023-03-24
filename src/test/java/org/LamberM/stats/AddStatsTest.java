package org.LamberM.stats;

import org.LamberM.UnitTest;
import org.LamberM.game.Level;
import org.LamberM.utils.InputReader;
import org.LamberM.utils.SystemInReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


import static org.mockito.Mockito.when;

class AddStatsTest implements UnitTest {
    @InjectMocks
    AddStats systemUnderTest;

    @Mock
    InputReader inputReaderMock;

    @Mock
    Level level;

    @Test
    void addStrengthTest(){
        //given
        level.setExp(120);
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("1");
        int expectedStrength = systemUnderTest.journey.createHero.myHero.getStats().getStrength()+5;
        int expectedCurrentPoints = systemUnderTest.getCurrentPoints();
        //when
        systemUnderTest.addStats();
        //then
        Assertions.assertEquals(expectedStrength,systemUnderTest.journey.createHero.myHero.getStats().getStrength());
        Assertions.assertEquals(expectedCurrentPoints,systemUnderTest.getCurrentPoints());
    }
    @Test
    void addDexterityTest(){
        //given
        level.setExp(120);
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("2");
        int expectedDexterity = systemUnderTest.journey.createHero.myHero.getStats().getDexterity()+5;
        int expectedCurrentPoints = systemUnderTest.getCurrentPoints();
        //when
        systemUnderTest.addStats();
        //then
        Assertions.assertEquals(expectedDexterity,systemUnderTest.journey.createHero.myHero.getStats().getDexterity());
        Assertions.assertEquals(expectedCurrentPoints,systemUnderTest.getCurrentPoints());
    }
    @Test
    void addIntelligenceTest(){
        //given
        level.setExp(120);
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("3");
        int expectedIntelligence = systemUnderTest.journey.createHero.myHero.getStats().getIntelligence()+5;
        int expectedCurrentPoints = systemUnderTest.getCurrentPoints();
        //when
        systemUnderTest.addStats();
        //then
        Assertions.assertEquals(expectedIntelligence,systemUnderTest.journey.createHero.myHero.getStats().getIntelligence());
        Assertions.assertEquals(expectedCurrentPoints,systemUnderTest.getCurrentPoints());
    }
    @Test
    void doubleAddStatsTest()
    {
        //given
        level.setExp(120);
        inputReaderMock = Mockito.mock(SystemInReader.class);
        when(inputReaderMock.read()).thenReturn("1");
        int expectedStrength = systemUnderTest.journey.createHero.myHero.getStats().getStrength()+5;
        int expectedCurrentPoints = systemUnderTest.getCurrentPoints();
        int expectedLvlToCompare= systemUnderTest.level.getLvlToCompare()+1;
        //when
        systemUnderTest.addStats();
        systemUnderTest.addStats();
        //then
        Assertions.assertEquals(expectedStrength,systemUnderTest.journey.createHero.myHero.getStats().getStrength());
        Assertions.assertEquals(expectedCurrentPoints,systemUnderTest.getCurrentPoints());
        Assertions.assertEquals(expectedLvlToCompare,systemUnderTest.level.getLvlToCompare());
    }
}