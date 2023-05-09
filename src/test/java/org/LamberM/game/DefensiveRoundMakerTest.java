package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.character.Assassin;
import org.LamberM.character.Character;
import org.LamberM.character.Sorcerer;
import org.LamberM.character.Warrior;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.OutputWriter;
import org.LamberM.utils.SystemInReader;
import org.LamberM.utils.SystemOutWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;


class DefensiveRoundMakerTest implements UnitTest {
    @InjectMocks
    DefensiveRoundMaker systemUnderTest;
    @Mock
    OutputWriter systemOutWriterMock;
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
    @Test
    void givenDefensiveSkillsIsNotNull_whenDefensiveSkills_thenRunSkill(){
        //given
        Character givenHero = mock(Character.class);
        MenuChooser menuChooserMock = mock(MenuChooser.class);
        when(givenHero.provideDefensiveSkillsMenu()).thenReturn(menuChooserMock);

        int userChoice = 1;
        when(menuChooserMock.userPick()).thenReturn(userChoice);

        HashMap<Integer, Runnable> defSkillsMap = new HashMap<>();
        when(givenHero.provideDefensiveSkills()).thenReturn(defSkillsMap);

        Runnable skillMock = mock(Runnable.class);
        defSkillsMap.put(userChoice, skillMock);

        //when
        systemUnderTest.defensiveSkills(givenHero);
        //then
        verify(skillMock).run();
    }
    @Test
    void givenDefensiveSkillsIsNull_whenDefensiveSkills_thenDoNotRunSkill(){
        //given
        Character givenHero = mock(Character.class);
        MenuChooser menuChooserMock = mock(MenuChooser.class);
        when(givenHero.provideDefensiveSkillsMenu()).thenReturn(menuChooserMock);

        int userChoice = 1;
        when(menuChooserMock.userPick()).thenReturn(userChoice);

        String text = "Back to menu";
        when(systemOutWriterMock.show(text)).thenReturn(text);
        //when
        systemUnderTest.defensiveSkills(givenHero);
        //then
        verify(systemOutWriterMock).show(text);
    }
}