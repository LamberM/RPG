//package org.LamberM.stats;
//
//import org.LamberM.UnitTest;
//import org.LamberM.character.Warrior;
//import org.LamberM.utils.MenuChooser;
//import org.LamberM.utils.SystemOutWriter;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//import static org.mockito.Mockito.when;
//
//class HeroAddStatsTest implements UnitTest {
//    @InjectMocks
//    HeroAddStats systemUnderTest;
//    @Mock
//    MenuChooser menuChooserMock;
//    @Mock
//    SystemOutWriter systemOutWriterMock;
//
//    @Test
//    void givenUserPickWarriorClassAndSetCurrentPoint_whenAddStats_thenCantAddStrength() {
//        //given
//        systemUnderTest.setCurrentPoints(0);
//        when(menuChooserMock.userPick()).thenReturn(1);
//        String expected = "You don't have enough points";
//        //when
//        systemUnderTest.addStats(new Warrior("does not matter"));
//        //then
//        Assertions.assertEquals(expected, systemOutWriterMock.show(expected));
//    }
//
//    @Test
//    void givenUserPickAndWarriorClass_whenAddStats_thenAddStrength2Times() {
//        //given
//        systemUnderTest.setMyHero(warriorMock);
//        warriorMock = new Warrior("does not matter");
//        systemUnderTest.setAddStatsMenuChooser(menuChooserMock);
//        when(menuChooserMock.userPick()).thenReturn(1, 1);
//        int expectedStrength = warriorMock.getStats().getStrength() + 10;
//        int expectedCurrentPoints = 0;
//        //when
//        systemUnderTest.addStats();
//        //then
//        Assertions.assertEquals(expectedStrength, warriorMock.getStats().getStrength());
//        Assertions.assertEquals(expectedCurrentPoints, systemUnderTest.getCurrentPoints());
//    }
//
//    @Test
//    void givenUserPickAndWarriorClass_whenAddStats_thenAddDexterity2Times() {
//        //given
//        systemUnderTest.setMyHero(warriorMock);
//        warriorMock = new Warrior("does not matter");
//        systemUnderTest.setAddStatsMenuChooser(menuChooserMock);
//        when(menuChooserMock.userPick()).thenReturn(2, 2);
//        int expectedDexterity = warriorMock.getStats().getDexterity() + 10;
//        int expectedCurrentPoints = 0;
//        //when
//        systemUnderTest.addStats();
//        //then
//        Assertions.assertEquals(expectedDexterity, warriorMock.getStats().getDexterity());
//        Assertions.assertEquals(expectedCurrentPoints, systemUnderTest.getCurrentPoints());
//    }
//
//    @Test
//    void givenUserPickAndWarriorClass_whenAddStats_thenAddIntelligence2Times() {
//        //given
//        systemUnderTest.setMyHero(warriorMock);
//        warriorMock = new Warrior("does not matter");
//        systemUnderTest.setAddStatsMenuChooser(menuChooserMock);
//        when(menuChooserMock.userPick()).thenReturn(3, 3);
//        int expectedIntelligence = warriorMock.getStats().getIntelligence() + 10;
//        int expectedCurrentPoints = 0;
//        //when
//        systemUnderTest.addStats();
//        //then
//        Assertions.assertEquals(expectedIntelligence, warriorMock.getStats().getIntelligence());
//        Assertions.assertEquals(expectedCurrentPoints, systemUnderTest.getCurrentPoints());
//    }
//
//    @Test
//    void givenUserPickAndWarriorClass_whenAddStats_thenAddIntelligenceAndDexterity() {
//        //given
//        systemUnderTest.setMyHero(warriorMock);
//        warriorMock = new Warrior("does not matter");
//        systemUnderTest.setAddStatsMenuChooser(menuChooserMock);
//        when(menuChooserMock.userPick()).thenReturn(3, 2);
//        int expectedIntelligence = warriorMock.getStats().getIntelligence() + 5;
//        int expectedDexterity = warriorMock.getStats().getDexterity() + 5;
//        int expectedCurrentPoints = 0;
//        //when
//        systemUnderTest.addStats();
//        //then
//        Assertions.assertEquals(expectedIntelligence, warriorMock.getStats().getIntelligence());
//        Assertions.assertEquals(expectedDexterity, warriorMock.getStats().getDexterity());
//        Assertions.assertEquals(expectedCurrentPoints, systemUnderTest.getCurrentPoints());
//    }
//
//}