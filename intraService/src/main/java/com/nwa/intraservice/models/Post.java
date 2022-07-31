package com.nwa.intraservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name ="Post")
public class Post extends AbstractEntity{

    @Column(name ="description")
    private String description;

    @Column(name = "nbrlike")
    private Long nbrLike;
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

}