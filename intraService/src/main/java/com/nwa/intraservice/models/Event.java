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
@Table(name ="event")
public class Event extends AbstractEntity{

    @Column(name = "title")
    private String title;

    @Column(name ="description")
    private String description;

    @Column(name ="visibility")
    private boolean visibility;

    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne(fetch = FetchType.EAGER )
    @JsonIgnore
    @JoinColumn(name = "iduser")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name = "user_event", joinColumns = {
            @JoinColumn(name = "idevent") }, inverseJoinColumns = {
            @JoinColumn(name = "iduser") })
    private List<User> users;
}