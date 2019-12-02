package io.inke.athena.common.utils;

import org.junit.Before;
import org.junit.Test;

public class TokenUtilsTest {

    private CharSequence source;
    private CharSequence sourceCrypto;

    @Before
    public void before() {
        source = "crypto";
    }

    @Test
    public void testGenerateValue() {
        System.out.println(TokenUtils.generateValue());
    }

    @Test
    public void testGenerateValueByParam() {
        System.out.println(TokenUtils.generateValue(source.toString()));
    }

    @Test
    public void testToHexString() {
        System.out.println(TokenUtils.toHexString(source.toString().getBytes()));
    }

}
