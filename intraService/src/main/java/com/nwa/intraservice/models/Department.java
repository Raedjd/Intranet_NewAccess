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

    @OneToMany(mappedBy="department",
            cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Product> products;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="department")
    private List<Tools> toolss;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="department")
    private List<User> users;
}