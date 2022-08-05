package com.nwa.intraservice.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Column(name ="place")
    private String place;

    @Column(name ="done")
    private Boolean done=false;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate ;
    private String userid;
    @ManyToOne(fetch = FetchType.EAGER )
    @JsonIgnore
    @JoinColumn(name = "iduser")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_event", joinColumns = {
            @JoinColumn(name = "idevent") }, inverseJoinColumns = {
            @JoinColumn(name = "iduser") })
    private List<User> users;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idevent")
    @JsonIgnore
    private List<Rating> ratings;


}