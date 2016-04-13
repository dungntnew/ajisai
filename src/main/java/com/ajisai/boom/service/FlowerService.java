package com.ajisai.boom.service;

import com.ajisai.boom.domain.Flower;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FlowerService {

    private static final int PAGE_SIZE = 10;

    public Map<String, Flower> getFlowers(String name) {

        List<Flower> flowers = dumpFlowers(PAGE_SIZE);
        return flowers.stream()
                .collect(Collectors.toMap(fi -> fi.getName(), fi -> fi, (f1, f2) -> f1));
    }

    private List<Flower> dumpFlowers(int size) {
        return IntStream
                .range(0, size)
                .mapToObj(i -> new Flower("flower: " + i, new Date()))
                .collect(Collectors.toList());
    }
}
