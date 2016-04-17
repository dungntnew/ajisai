package com.ajisai.boom.repository;

import com.ajisai.boom.domain.Customer;
import com.ajisai.boom.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
