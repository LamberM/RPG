package org.LamberM.game;

import org.LamberM.UnitTest;
import org.LamberM.character.Character;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class EnemyCreatorTest implements UnitTest {
    @InjectMocks
    EnemyCreator systemUnderTest;

    @Test
    void givenEnemy_whenCreateEnemy_thenCorrectCreateHero() {
        //given
        //when
        Character result = systemUnderTest.createEnemy();
        //then
        Assertions.assertEquals("Glen", result.getName());
        Assertions.assertEquals(15, result.getStats().getStrength());
        Assertions.assertEquals(20, result.getStats().getDexterity());
        Assertions.assertEquals(10, result.getStats().getIntelligence());
        Assertions.assertEquals(150, result.getStats().getHp());
        Assertions.assertEquals(1, result.getStats().getMp());
        Assertions.assertEquals(10, result.getStats().getDodge());
        Assertions.assertEquals(60, result.getStats().getArmor());
        Assertions.assertEquals(10, result.getStats().getCriticalChance());
        Assertions.assertEquals(1, result.getStats().getAttackRange());
    }
}