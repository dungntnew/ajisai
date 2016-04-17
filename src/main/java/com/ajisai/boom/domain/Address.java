package com.ajisai.boom.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Entity(name = "address")
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    private String country;
    private String city;

//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
//    private Customer customer;
}
