package com.nwa.intraservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    private Rolee role;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNationnality() {
        return nationnality;
    }

    public void setNationnality(String nationnality) {
        this.nationnality = nationnality;
    }

    public Rolee getRole() {
        return role;
    }

    public void setRole(Rolee role) {
        this.role = role;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEventss() {
        return eventss;
    }

    public void setEventss(List<Event> eventss) {
        this.eventss = eventss;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Love> getLoves() {
        return loves;
    }

    public void setLoves(List<Love> loves) {
        this.loves = loves;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Tools> getToolss() {
        return toolss;
    }

    public void setToolss(List<Tools> toolss) {
        this.toolss = toolss;
    }
}
