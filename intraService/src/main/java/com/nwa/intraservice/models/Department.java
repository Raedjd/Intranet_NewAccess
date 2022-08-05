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
@Table(name ="department")
public class Department extends AbstractEntity{

    @Column(name = "namedepart")
    private String nameDepart;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDepartment")
    private List<Product> products;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDepartment")
    private List<Tools> toolss;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDepartment")
    @JsonIgnoreProperties(value = {"department"}, allowGetters = true)
    private List<User> users;


}