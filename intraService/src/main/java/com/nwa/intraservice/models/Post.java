package com.nwa.intraservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name ="Post")
public class Post extends AbstractEntity{

    @Column(name ="description")
    private String description;
    private String userid;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="post")
    @JsonIgnore
    private List<Comment> comments;

    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.REMOVE)
    @JsonIgnore
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idimage")
    private Image image;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="post")
    @JsonIgnore
    private List<Love> loves;

    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Love> getLoves() {
        return loves;
    }

    public void setLoves(List<Love> loves) {
        this.loves = loves;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}