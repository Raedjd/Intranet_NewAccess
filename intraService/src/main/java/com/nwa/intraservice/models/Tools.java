package com.nwa.intraservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name ="tools")
public class Tools extends  AbstractEntity{

    @Column(name = "nametools")
    private String nameTools;

    @Column(name = "nbrtools")
    private String nbrTools;

    @ManyToOne(fetch = FetchType.EAGER )
    @JsonIgnore
    @JoinColumn(name = "idDepartment" )
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER  )
    @JsonIgnore
    @JoinColumn(name = "iduser")
    private User user;
}
