package io.inke.athena.common.crypto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CryptoCommonTest {

    private CharSequence source;
    private CharSequence sourceCrypto;

    @Before
    public void before() {
        source = "crypto";
    }

    @Test
    public void testBcryptEncoder() {
        System.out.println(CryptoCommon.bcryptEncoder(source));
        Assert.assertNotNull(CryptoCommon.bcryptEncoder(source));
    }

}
