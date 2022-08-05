package com.nwa.intraservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name ="image")
public class Image extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @Column(name= "imageUrl")
    private String imageUrl ;

    @Column(name ="imageid")
    private String imageId;


}
