package io.inke.athena.support.provider;

import io.inke.athena.support.BaseTest;
import io.inke.athena.support.model.AppmetaModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppmetaProviderTest implements BaseTest {

    private AppmetaModel appmeta;
    private AppmetaProvider appmetaProvider;
    private String value = "AppmetaProviderTest";

    @Before
    public void before() {
        appmetaProvider = new AppmetaProvider();
        appmeta = new AppmetaModel();
        appmeta.setName(value);
        appmeta.setCode(value);
        appmeta.setDisplayName(value);
        appmeta.setToken(value);
    }

    @After
    public void after() {
    }

    @Test
    public void testAddModel() {
        Assert.assertNotNull(appmetaProvider.addModel(appmeta));
    }

}
