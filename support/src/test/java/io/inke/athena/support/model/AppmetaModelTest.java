package io.inke.athena.support.model;

import io.inke.athena.support.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppmetaModelTest implements BaseTest {

    private AppmetaModel appmeta;

    @Before
    public void before() {
        appmeta = new AppmetaModel();
    }

    @After
    public void after() {
    }

    @Test
    public void testConstructor() {
        Assert.assertNotNull(appmeta);
    }

}
