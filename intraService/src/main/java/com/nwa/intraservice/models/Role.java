package com.nwa.intraservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name ="role")
public class Role extends AbstractEntity{

    @Column(name = "role")
    private String role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="role")
    private List<User> users;
}
