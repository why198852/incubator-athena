package io.inke.athena.support.mapper;

import io.inke.athena.support.ApplicationTest;
import io.inke.athena.support.BaseTest;
import io.inke.athena.support.model.AppmetaModel;
import io.inke.athena.support.model.UserModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(
        classes = ApplicationTest.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class AppmetaMapperTest implements BaseTest {

    private AppmetaModel appmeta;
    private String value = "AppmetaMapperTest";

    @Autowired
    private AppmetaMapper appmetaMapper;

    @Before
    public void before() {
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
    public void testInsertModel() {
        Assert.assertTrue(this.appmetaMapper.insertModel(appmeta) > 0);
    }

    @Test
    public void testFindByName() {
        AppmetaModel temp = this.appmetaMapper.findByName(value);
        System.out.println(temp.toString());
        Assert.assertNotNull(temp);
    }

    @Test
    public void testFindById() {
        AppmetaModel temp = this.appmetaMapper.findById(1L);
        System.out.println(temp.toString());
        Assert.assertNotNull(temp);
    }

    @Test
    public void testFindAllByUserId() {
        List<AppmetaModel> modelList = this.appmetaMapper.findAllByUserId(1L);
        modelList.forEach(v -> System.out.println(v.toString()));
    }

}
