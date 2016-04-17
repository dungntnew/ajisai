package com.ajisai.boom.repository;

import com.ajisai.boom.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select * from orders where customer_id = :customer_id", nativeQuery = true)
    List<Order> findByPk(@Param("customer_id") Long customerId);
}
