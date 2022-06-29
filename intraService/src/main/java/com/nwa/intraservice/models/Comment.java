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

    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idPost")
    private Post post;
}