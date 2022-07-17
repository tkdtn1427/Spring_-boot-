package com.codestates.UnitTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class AssertionNullHamcrestTest {

    @DisplayName("AssertionNull() Test")
    @Test
    public void assertNotNullTest() {
        String currencyName = getCryptoCurrency("ETH");

        assertThat(currencyName,is(nullValue()));
//        assertThat(currencyName,is(notNullValue()));
    }

    private String getCryptoCurrency(String unit) {
        return CryptoCurrency.map.get(unit);
    }
}
