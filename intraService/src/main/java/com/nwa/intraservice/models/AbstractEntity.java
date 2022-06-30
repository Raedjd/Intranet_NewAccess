package com.nwa.intraservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    @Column(name = "creationDate")
    @JsonIgnore
    private LocalDate creationDate= LocalDate.now();

    @LastModifiedDate
    @Column(name = "LastModifiedDate")
    @JsonIgnore
    private LocalDate lastUpdateDate= LocalDate.now();
}