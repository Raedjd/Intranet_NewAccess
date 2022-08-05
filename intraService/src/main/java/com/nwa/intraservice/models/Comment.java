package com.nwa.intraservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name ="comment")
public class Comment extends AbstractEntity {

    private String comment;

    @ManyToOne
    @JoinColumn(name = "idPost")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

}