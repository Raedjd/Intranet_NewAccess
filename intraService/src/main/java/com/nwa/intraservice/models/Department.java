package com.nwa.intraservice.models;

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
@Table(name ="department")
public class Department extends AbstractEntity{

    @Column(name = "namedepart")
    private String nameDepart;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="department")
    private List<ProductOfDepartment> ProductOfDepartment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="department")
    private List<Tools> toolss;
}