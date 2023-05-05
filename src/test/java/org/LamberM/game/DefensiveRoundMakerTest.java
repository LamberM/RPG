package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.character.Assassin;
import org.LamberM.character.Sorcerer;
import org.LamberM.character.Warrior;
import org.LamberM.utils.MenuChooser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;


import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class DefensiveRoundMakerTest implements UnitTest {
    @InjectMocks
    DefensiveRoundMaker systemUnderTest;
    /////////////////////////// class does not matter //////////////////////////////
    @Test
    void givenWarriorAndExpectedHpMp_whenRest_thenCorrectlyUseRest() {
        //given
        Warrior givenWarrior = new Warrior("does not matter");
        int expectedHP = givenWarrior.getDuelStats().getHp();
        int expectedMP = givenWarrior.getDuelStats().getMp();
        //when
        systemUnderTest.rest(givenWarrior);
        //then
        Assertions.assertEquals(expectedHP, givenWarrior.getDuelStats().getHp());
        Assertions.assertEquals(expectedMP, givenWarrior.getDuelStats().getMp());
    }
    /////////////////////////// warrior skills /////////////////////////////////////

    @Test
    void givenWarriorAndProvider_whenDefensiveSkills_thenCanUseBattleCry(){
        //given
        int userChoice=1;
        Warrior givenWarrior = new Warrior("does not matter");
        MenuChooser menuChooserMock = mock(MenuChooser.class);
        when(menuChooserMock.userPick()).thenReturn(givenWarrior.provideDefensiveSkillsMenu().userPick());
        when(givenWarrior.provideDefensiveSkillsMenu().userPick()).thenReturn(userChoice);
        Map<Integer,Runnable> defSkillsMap = new HashMap<>();
        when(defSkillsMap).thenReturn(givenWarrior.provideDefensiveSkills());
        Runnable useDefSkill = null;
        when(useDefSkill).thenReturn(givenWarrior.provideDefensiveSkills().get(userChoice));
        //when
        systemUnderTest.defensiveSkills(givenWarrior);
        //then
        int expectedStr = givenWarrior.getDuelStats().getStrength() + 10;
        int expectedArmor = givenWarrior.getDuelStats().getArmor() + 5;
        int expectedCritC = givenWarrior.getDuelStats().getCriticalChance() + 2;
        int expectedMp = givenWarrior.getDuelStats().getMp() - 20;
        Assertions.assertEquals(expectedStr, givenWarrior.getDuelStats().getStrength());
        Assertions.assertEquals(expectedArmor, givenWarrior.getDuelStats().getArmor());
        Assertions.assertEquals(expectedCritC, givenWarrior.getDuelStats().getCriticalChance());
        Assertions.assertEquals(expectedMp, givenWarrior.getDuelStats().getMp());
    }
    @Test
    void givenWarriorAndProvider_whenDefensiveSkills_thenCanUseDefensiveCry(){
        //given
        Warrior givenWarrior = mock(Warrior.class);
        MenuChooser menuChooserMock = mock(MenuChooser.class);
        when(givenWarrior.provideDefensiveSkillsMenu().userPick()).thenReturn(1);
        //when
        systemUnderTest.defensiveSkills(givenWarrior);
        //then
        int expectedHp= givenWarrior.getDuelStats().getHp() + 20;
        int expectedArmor= givenWarrior.getDuelStats().getArmor() + 10;
        int expectedDodge= givenWarrior.getDuelStats().getDodge() + 2;
        int expectedMp=givenWarrior.getDuelStats().getMp() - 20;
        Assertions.assertEquals(expectedHp, givenWarrior.getDuelStats().getHp());
        Assertions.assertEquals(expectedArmor, givenWarrior.getDuelStats().getArmor());
        Assertions.assertEquals(expectedDodge, givenWarrior.getDuelStats().getDodge());
        Assertions.assertEquals(expectedMp, givenWarrior.getDuelStats().getMp());
    }
    //////////////////////////////////assassin skills//////////////////////////////////
    @Test
    void givenAssassinAndProvider_whenDefensiveSkills_thenCanUseBoostAndDexterity(){
        //given
        Assassin givenAssassin = new Assassin("does not matter");
        givenAssassin.provideDefensiveSkills().get(1);
        //when
        systemUnderTest.defensiveSkills(givenAssassin);
        //then
        int expectedDexterity=givenAssassin.getDuelStats().getDexterity() + 10;
        int expectedDodge = givenAssassin.getDuelStats().getDodge() + 5;
        int expectedCriticalChance = givenAssassin.getDuelStats().getCriticalChance() + 5;
        int expectedMp=givenAssassin.getDuelStats().getMp() - 20;
        Assertions.assertEquals(expectedDexterity, givenAssassin.getDuelStats().getDexterity());
        Assertions.assertEquals(expectedDodge, givenAssassin.getDuelStats().getDodge());
        Assertions.assertEquals(expectedCriticalChance, givenAssassin.getDuelStats().getArmor());
        Assertions.assertEquals(expectedMp, givenAssassin.getDuelStats().getMp());
    }
    /////////////////////////////////sorcerer skills//////////////////////////////////
    @Test
    void givenSorcererAndProvider_whenDefensiveSkills_thenCanUseFrostArmor(){
        //given
        Sorcerer givenSorcerer = new Sorcerer("does not matter");
        givenSorcerer.provideDefensiveSkills().get(1);
        //when
        systemUnderTest.defensiveSkills(givenSorcerer);
        //then
        int expectedArmor = givenSorcerer.getDuelStats().getArmor()+10;
        int expectedMp = givenSorcerer.getDuelStats().getMp()-20;
        Assertions.assertEquals(expectedArmor,givenSorcerer.getDuelStats().getArmor());
        Assertions.assertEquals(expectedMp,givenSorcerer.getDuelStats().getMp());
    }
}