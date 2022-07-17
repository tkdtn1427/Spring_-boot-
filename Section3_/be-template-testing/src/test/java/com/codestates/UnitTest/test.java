package com.codestates.UnitTest;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class test extends TypeSafeMatcher {

    @Override
    protected boolean matchesSafely(Object item) {
        return false;
    }

    @Override
    public void describeTo(Description description) {

    }
}
