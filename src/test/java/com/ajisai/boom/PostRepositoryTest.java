package com.ajisai.boom;

import com.ajisai.boom.service.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AjisaiApp.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void executeQueryCount() {
        Long count = postRepository.count();
        Assert.isTrue(count == 0);
    }
}
