package com.nwa.intraservice.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name ="product")
public class Product extends AbstractEntity {{}
        @Column(name="nameproduct")
        private String nameProduct;
        @ManyToOne
        @JsonIgnore
        private Department department;

    }



