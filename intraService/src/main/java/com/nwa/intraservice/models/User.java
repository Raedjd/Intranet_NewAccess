package com.nwa.intraservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "mail")
    private String mail;

    @Column(name ="birthdate")
    private Date birthdate;

    @Column(name =" adresse")
    private String adresse;

    @Column(name ="phone")
    private Long phone;

    @Column(name = "picture")
    private String picture;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Tools> toolss;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Post> posts;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Event> events;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_event", joinColumns = {
            @JoinColumn(name = "iduser") }, inverseJoinColumns = {
            @JoinColumn(name = "idevent") })
    private List<Event> eventsusers;

    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idDepartment")
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idRole")
    private Role role;
}
