package com.ajisai.boom.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

// TODO: add created_date, last modified_date
@MappedSuperclass
@Data
public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "seq")
    @Column(name = "id")
    private Long id = 0L;


//    @CreatedDate
//    @Column(name = "created_date")
//    private Date createdDate;


//    @LastModifiedDate
//    @Version
//    @Column(name = "created_date", insertable = true, updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date modifiedDate;
}
