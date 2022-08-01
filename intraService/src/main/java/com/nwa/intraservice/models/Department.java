package com.nwa.intraservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.util.List;

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

    public String getNameDepart() {
        return nameDepart;
    }

    public void setNameDepart(String nameDepart) {
        this.nameDepart = nameDepart;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Tools> getToolss() {
        return toolss;
    }

    public void setToolss(List<Tools> toolss) {
        this.toolss = toolss;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}