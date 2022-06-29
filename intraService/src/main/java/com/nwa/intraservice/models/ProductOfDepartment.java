package com.nwa.intraservice.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name ="productdepart")
public class ProductOfDepartment extends AbstractEntity {
        @Column(name="nameproduct")
        private String nameProduct;



    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idDepartment")
    private Department department;

    }



