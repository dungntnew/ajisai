package com.ajisai.boom.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Builder
@Data
@Entity()
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "customer",
            fetch = FetchType.LAZY)
    private List<Order> orders = new LinkedList<>();
}
