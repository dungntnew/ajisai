package com.ajisai.boom.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@AllArgsConstructor
public class Flower {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private String name;
    private Date startDate;
}
