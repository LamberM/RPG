package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.character.Character;
import org.LamberM.character.Enemy;
import org.LamberM.character.Warrior;
import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;
import org.LamberM.utils.OutputWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.HashMap;

import static org.mockito.Mockito.*;


class OffensiveRoundMakerTest implements UnitTest {
    @InjectMocks
    OffensiveRoundMaker systemUnderTest;
    @Mock
    OutputWriter systemOutWriterMock;
    @Test
    void givenHeroAndEnemy_whenHeroAttack_thenDamage() {
        //given
        Warrior givenHero = new Warrior("does not matter");
        Enemy givenEnemy = new Enemy("does not matter");
        int enemyHpBeforeHeroAttack = givenEnemy.getDuelStats().getHp();
        //when
        systemUnderTest.attack(givenHero, givenEnemy);
        //then
        int enemyHpAfterHeroAttack = givenEnemy.getDuelStats().getHp();
        Assertions.assertTrue(enemyHpAfterHeroAttack <= enemyHpBeforeHeroAttack);
    }

    @Test
    void givenHeroAndEnemy_whenEnemyAttack_thenDamage() {
        //given
        Warrior givenHero = new Warrior("does not matter");
        Enemy givenEnemy = new Enemy("does not matter");
        int myHeroHpBeforeEnemyAttack = givenHero.getDuelStats().getHp();
        //when
        systemUnderTest.attack(givenEnemy, givenHero);
        //then
        int myHeroHpAfterEnemyAttack = givenHero.getDuelStats().getHp();
        Assertions.assertTrue(myHeroHpAfterEnemyAttack <= myHeroHpBeforeEnemyAttack);
    }

    @Test
    void givenOffensiveSkillsIsNotNull_whenOffensiveSkills_thenRunSkill(){
        //given
        Character givenHero = mock(Character.class);
        Character enemyMock = mock(Character.class);
        MenuChooser menuChooserMock = mock(MenuChooser.class);
        when(givenHero.provideOffensiveSkillsMenu()).thenReturn(menuChooserMock);

        int userChoice = 1;
        when(menuChooserMock.userPick()).thenReturn(userChoice);

        HashMap<Integer, Runnable> offSkillsMap = new HashMap<>();
        when(givenHero.provideOffensiveSkills()).thenReturn(offSkillsMap);

        Runnable skillMock = mock(Runnable.class);
        offSkillsMap.put(userChoice, skillMock);

        Stats statsMock = mock(Stats.class);
        when(givenHero.getDuelStats()).thenReturn(statsMock);
        when(enemyMock.getDuelStats()).thenReturn(statsMock);
        //when
        systemUnderTest.offensiveSkills(givenHero,enemyMock);
        //then
        verify(skillMock).run();
    }
    @Test
    void givenOffensiveSkillsIsNull_whenOffensiveSkills_thenDoNotRunSkill(){
        //given
        Character givenHero = mock(Character.class);
        Character enemyMock = mock(Character.class);
        MenuChooser menuChooserMock = mock(MenuChooser.class);
        when(givenHero.provideOffensiveSkillsMenu()).thenReturn(menuChooserMock);

        int userChoice = 1;
        when(menuChooserMock.userPick()).thenReturn(userChoice);

        String text = "Back to menu";
        when(systemOutWriterMock.show(text)).thenReturn(text);
        //when
        systemUnderTest.offensiveSkills(givenHero,enemyMock);
        //then
        verify(systemOutWriterMock).show(text);
    }
}