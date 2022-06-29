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
@Table(name ="Post")
public class Post extends AbstractEntity{

    @Column(name ="description")
    private String description;

    @Column(name ="visiblity")
    private boolean visibility;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "enddate")
    private Date endDate;

    @Column(name = "picture")
    private Date picture;

    @Column(name = "nbrlike")
    private Long nbrLike;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="post")
    private List<Comment> comments;
}