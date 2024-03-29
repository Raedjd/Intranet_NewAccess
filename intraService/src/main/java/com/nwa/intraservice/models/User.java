package com.nwa.intraservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name ="user")
public class User extends AbstractEntity{
    @Column(name = "username")
    private String username;

    @Column(name= "firstname")
    private String firstName;

    @Column(name ="lastname")
    private String lastName;

    @Column(name = "mail" )
    private String mail;

    @Column(name ="birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @Column(name ="nationnality")
    private String nationnality;

    @Column(name ="poste")
    private String poste;

    @Column(name ="phone")
    private Long phone;


    @Column(name = "password")
    private String password;

    @Column(name ="isblocked")
    private Boolean isBlocked=false;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    @JsonIgnore
    private List<Tools> toolss;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    @JsonIgnore
    private List<Post> posts;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    @JsonIgnore
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    @JsonIgnore
    private List<Event> events;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_event", joinColumns = {
            @JoinColumn(name = "iduser") }, inverseJoinColumns = {
            @JoinColumn(name = "idevent") })
    @JsonIgnore
    private List<Event> eventss;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDepartment")
    @JsonIgnoreProperties({"department","user"})
    @JsonIgnore
    private Department department;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idimage")
    private Image image;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "iduser")
    @JsonIgnore
    private List<Rating> ratings;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "iduser")
    @JsonIgnore
    private List<Love> loves;

}