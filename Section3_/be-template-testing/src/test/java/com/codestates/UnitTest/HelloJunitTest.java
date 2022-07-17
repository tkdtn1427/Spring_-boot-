package com.codestates.UnitTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class HelloJunitTest {
    @DisplayName("Hello Junit Test")
    @Test
    public void assertionTest1() {
        String actual = "Hello, World";
        String expected = "Hello, JUnit";

        assertThat(actual, is(equalTo(expected)));
    }
}