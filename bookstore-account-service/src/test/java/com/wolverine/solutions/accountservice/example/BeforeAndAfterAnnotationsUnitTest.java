package com.wolverine.solutions.accountservice.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * @author Sumit Sarkar
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BeforeAndAfterAnnotationsUnitTest {

    String input;
    Long result;

    @BeforeAll
    public void setup() {
        input = "77";
    }

    @AfterAll
    public void teardown() {
        input = null;
        result = null;
    }

    @Test
    public void whenConvertStringToLong_thenResultShouldBeLong() {
        result = Long.valueOf(input);
        Assertions.assertEquals(77l, result);
    }
}
