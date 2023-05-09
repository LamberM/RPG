package org.LamberM.utils;

import org.LamberM.UnitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class SystemOutWriterTest implements UnitTest {
    @InjectMocks
    SystemOutWriter systemUnderTest;

    @Test
    void givenText_whenWrite_thenShowText(){
        //given
        //when
        String actual = systemUnderTest.show("TEEEEEST");
        //then
        Assertions.assertEquals("TEEEEEST",actual);
    }
}