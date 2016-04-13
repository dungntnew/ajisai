package com.ajisai.boom.repository;

import com.ajisai.boom.domain.Flower;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface FlowerRepository extends Repository<Flower, Long> {

    public List<Flower> findByNameStartingWith(String name);

    public Optional<Flower> findOne(Long id);

    public List<Flower> findAll();
}
