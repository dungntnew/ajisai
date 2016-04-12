package com.ajisai.boom.domain;

import lombok.Data;
import org.springframework.data.jpa.repository.*;

import javax.persistence.*;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Post extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name="created_date")
    private Date orderDate;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;
}
