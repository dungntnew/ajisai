package com.ajisai.boom.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flower implements Serializable {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Flower(String name, String startDate) {
        super();
        this.name = name;
        this.startDate = startDate;
        this.description = "";
    }

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "seq")
    @Column(name = "id")
    private Long id = 0L;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "description")
    private String description;
}
