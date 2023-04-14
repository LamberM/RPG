package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.character.Enemy;
import org.LamberM.character.Warrior;
import org.LamberM.stats.Stats;
import org.LamberM.utils.MenuChooser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.mockito.Mockito.when;


class OffensiveRoundTest implements UnitTest {
    @InjectMocks
    OffensiveRound systemUnderTest;
    @Mock
    Warrior warriorMock;
    @Mock
    Enemy enemyMock;
    @Mock
    MenuChooser menuChooserMock;

    @Test
    void givenHeroAndEnemy_whenHeroAttack_thenDamage() {
        //given
        warriorMock = new Warrior("does not matter");
        enemyMock = new Enemy("does not matter", new Stats(15, 20, 10, 150, 1, 10, 60, 10, 1));
        systemUnderTest.setMyHero(warriorMock);
        systemUnderTest.setEnemy(enemyMock);
        int enemyHpBeforeHeroAttack = enemyMock.getDuelStats().getHp();
        //when
        systemUnderTest.heroAttack();
        //then
        int enemyHpAfterHeroAttack = enemyMock.getDuelStats().getHp();
        Assertions.assertTrue(enemyHpAfterHeroAttack <= enemyHpBeforeHeroAttack);
    }

    @Test
    void givenHeroAndEnemy_whenEnemyAttack_thenDamage() {
        //given
        warriorMock = new Warrior("does not matter");
        enemyMock = new Enemy("does not matter", new Stats(15, 20, 10, 150, 1, 10, 60, 10, 1));
        systemUnderTest.setMyHero(warriorMock);
        systemUnderTest.setEnemy(enemyMock);
        int myHeroHpBeforeEnemyAttack = enemyMock.getDuelStats().getHp();
        //when
        systemUnderTest.enemyAttack();
        //then
        int myHeroHpAfterEnemyAttack = enemyMock.getDuelStats().getHp();
        Assertions.assertTrue(myHeroHpAfterEnemyAttack <= myHeroHpBeforeEnemyAttack);
    }

    @Test
    void givenHeroAndEnemy_whenOffensiveSkills_thenDamage() {
        //given
        warriorMock = new Warrior("does not matter");
        enemyMock = new Enemy("does not matter", new Stats(15, 20, 10, 150, 1, 10, 60, 10, 1));
        systemUnderTest.setMyHero(warriorMock);
        systemUnderTest.setEnemy(enemyMock);
        warriorMock.setOffensiveSkillsMenu(menuChooserMock);
        when(warriorMock.offensiveSkillsMenu()).thenReturn(1);
        int enemyHpBeforeHeroAttack = enemyMock.getDuelStats().getHp();
        //when
        systemUnderTest.offensiveSkills();
        //then
        int enemyHpAfterHeroAttack = enemyMock.getDuelStats().getHp();
        Assertions.assertTrue(enemyHpAfterHeroAttack <= enemyHpBeforeHeroAttack);
    }
}