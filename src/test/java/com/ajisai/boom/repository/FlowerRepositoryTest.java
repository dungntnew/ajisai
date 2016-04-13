package com.ajisai.boom.repository;

import com.ajisai.boom.AjisaiApp;
import com.ajisai.boom.AjisaiTestContext;
import com.ajisai.boom.domain.Flower;
import com.google.common.collect.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = { AjisaiApp.class, AjisaiTestContext.class })
@ActiveProfiles("test")
public class FlowerRepositoryTest {

    @Autowired
    private FlowerRepository repository;

    private List<Flower> flowerList;

    @Before
    public void before() throws Exception {
        Flower flower1 = new Flower(101L, "green ajisai", "2016-01-01", "===X====");
        Flower flower2 = new Flower(102L, "black ajisai", "2016-01-01", "===Y====");
        Flower flower3 = new Flower(102L, "red ajisai", "2016-01-01", "===Z====");

        flowerList = Lists.newArrayList(flower1, flower2, flower3);
        repository.save(flowerList);
    }

    @After
    public void after() throws Exception {
        repository.delete(flowerList);
    }

    @Test
    public void testNormal() throws Exception {
        Flower flower = new Flower(1260L, "red eye", "2016-01-02", "==TEXT==");
        List<Flower> all = repository.findAll();

        repository.save(flower);
        List<Flower> newAll = repository.findAll();

        Assert.isTrue(1 == (newAll.size() -all.size()));
    }

    @Test
    public void testCount() {
        Assert.isTrue(repository.findAll().size() != 0);
    }
}
