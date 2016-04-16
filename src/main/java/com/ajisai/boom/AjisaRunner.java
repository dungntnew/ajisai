package com.ajisai.boom;

import com.ajisai.boom.config.setting.HugoSetting;
import com.ajisai.boom.config.setting.MySetting;
import com.ajisai.boom.domain.Flower;
import com.ajisai.boom.repository.FlowerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.IntStream;

import static java.lang.String.format;

@SpringBootApplication()
public class AjisaRunner {

    static Logger logger = LoggerFactory.getLogger(AjisaRunner.class);

    @Autowired
    FlowerRepository repository;

    public void testRepo1() {

        repository.deleteAll();

        IntStream.range(0, 10).forEach(i -> {
            Flower f = Flower.builder()
                    .name(format("ajisa %s", i))
                    .description("a ajisa Linh Xinh")
                    .startDate(format("2016-01-%s", i))
                    .build();
            repository.save(f);
        });

        repository.findAll().forEach(flower -> {
            logger.info(format("===> %s", flower));
        });
    }

    public static void main(String... args) {
        try (ConfigurableApplicationContext ctx = SpringApplication.run(AjisaRunner.class, args)) {
            AjisaRunner runner = ctx.getBean(AjisaRunner.class);
            //runner.testRepo1();

            HugoSetting hugoSetting = ctx.getBean(HugoSetting.class);
            logger.info(hugoSetting.toString());

            MySetting mySetting = ctx.getBean(MySetting.class);
            logger.info(mySetting.toString());
        }
        ;
    }
}
