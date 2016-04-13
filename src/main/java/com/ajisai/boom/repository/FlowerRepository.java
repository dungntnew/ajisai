package com.ajisai.boom.repository;

import com.ajisai.boom.domain.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlowerRepository extends JpaRepository<Flower, Long> {

    public List<Flower> findByNameStartingWith(String name);
}
