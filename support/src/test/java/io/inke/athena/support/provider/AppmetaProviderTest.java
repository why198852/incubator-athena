package io.inke.athena.support.provider;

import io.inke.athena.support.BaseTest;
import io.inke.athena.support.model.AppmetaModel;
import io.inke.athena.support.model.UserModel;
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
        UserModel user = new UserModel();
        user.setId(1);
        appmeta.setUser(user);
    }

    @After
    public void after() {
    }

    @Test
    public void testAddModel() {
        String sql = appmetaProvider.addModel(appmeta);
        System.out.println(sql);
        Assert.assertNotNull(sql);
    }

}
