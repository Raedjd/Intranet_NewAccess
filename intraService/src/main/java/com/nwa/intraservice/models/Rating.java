package com.nwa.intraservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({"rating","user"})
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"rating","event"})
    private Event event;
}
