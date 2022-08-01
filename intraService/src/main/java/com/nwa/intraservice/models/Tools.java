package com.nwa.intraservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name ="tools")
public class Tools extends  AbstractEntity{

    @Column(name = "nametools")
    private String nameTools;

    @Column(name = "nbrtools")
    private String nbrTools;
    private String userid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDepartment")
    @JsonIgnoreProperties({"department","tools"})
    @JsonIgnore
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER  )
    @JsonIgnore
    @JoinColumn(name = "iduser")
    private User user;

    public String getNameTools() {
        return nameTools;
    }

    public void setNameTools(String nameTools) {
        this.nameTools = nameTools;
    }

    public String getNbrTools() {
        return nbrTools;
    }

    public void setNbrTools(String nbrTools) {
        this.nbrTools = nbrTools;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
