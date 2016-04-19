package com.ajisai.boom.service;

import com.ajisai.boom.domain.Flower;
import com.ajisai.boom.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FlowerService {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private FlowerRepository flowerRepository;

    public Map<String, Flower> getFlowers(String name) {

        List<Flower> flowers = flowerRepository.findAll();

        return flowers.stream()
                .collect(Collectors.toMap(fi -> fi.getName(), fi -> fi, (f1, f2) -> f1));
    }

    public Optional<Flower> getFlower(Long id) {

        Flower flower = flowerRepository.findOne(id);
        return Optional.ofNullable(flower);
    }

    private List<Flower> dumpFlowers(int size) {
        return IntStream
                .range(0, size)
                .mapToObj(i -> new Flower("flower: " + i, "2016-01-20", "xxx"))
                .collect(Collectors.toList());
    }
}
