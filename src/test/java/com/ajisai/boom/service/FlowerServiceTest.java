package com.ajisai.boom.service;

import com.ajisai.boom.AjisaiApp;
import com.ajisai.boom.AjisaiTestContext;
import com.ajisai.boom.domain.Flower;
import com.ajisai.boom.repository.FlowerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = { AjisaiApp.class, AjisaiTestContext.class })
@ActiveProfiles("test")
public class FlowerServiceTest {

    @InjectMocks
    private FlowerService flowerService;

    @Mock
    private FlowerRepository flowerRepository;


    private Flower responseOk;
    private List<Flower> responseListOk;

    @Before
    public void before() throws Exception {
        Flower flower1 = new Flower("red flower", "2016-01-01", "example1");
        Flower flower2 = new Flower("blue flower", "2016-02-01", "example2");

        responseOk = flower1;

        responseListOk = new ArrayList<>();
        responseListOk.add(flower1);
        responseListOk.add(flower2);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getFlower() throws Exception {
        Mockito.when(flowerRepository.findOne(0L)).thenReturn(responseOk);
        Optional<Flower> flower = flowerService.getFlower(0L);
        Assert.isTrue(flower != null);
        Assert.isTrue(flower.isPresent());
        Assert.isTrue(flower.get().getName().equals(responseOk.getName()));
    }

    @Test
    public void getFlowers() throws Exception {
        Mockito.when(flowerRepository.findAll()).thenReturn(responseListOk);
        Map<String, Flower> flowers = flowerService.getFlowers("");
        Assert.isTrue(flowers != null);
        Assert.isTrue(flowers.size() == 2);
        Assert.isTrue(flowers.containsKey(responseListOk.get(0).getName()));
    }
}
