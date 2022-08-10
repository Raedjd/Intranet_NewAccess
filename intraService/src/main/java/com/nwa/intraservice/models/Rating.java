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
@Table(name ="rating")
public class Rating extends  AbstractEntity {

    @Column(name = "scoreRating")
    private float scoreRating;


    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Event event;


}