package io.inke.athena.support.service;

import io.inke.athena.support.ApplicationTest;
import io.inke.athena.support.BaseTest;
import io.inke.athena.support.model.AppmetaModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(
        classes = ApplicationTest.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class AppmetaServiceTest implements BaseTest {

    private AppmetaModel appmeta;
    private String value = "AppmetaServiceTest";

    @Autowired
    private AppmetaService appmetaService;

    @Before
    public void before() {
        appmeta = new AppmetaModel();
        appmeta.setName(value);
        appmeta.setCode(value);
        appmeta.setDisplayName(value);
        appmeta.setToken(value);
        appmeta.setUserId(1);
    }

    @After
    public void after() {

    }

    @Test
    public void testAddObject() {
        Assert.assertTrue(this.appmetaService.addObject(appmeta).getDetail() > 0);
    }

    @Test
    public void testGetByName() {
        Assert.assertNotNull(this.appmetaService.getByName(value).getDetail());
    }

}
