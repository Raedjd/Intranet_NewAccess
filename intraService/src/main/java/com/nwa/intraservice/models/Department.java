package com.nwa.intraservice.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

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
@Table(name ="department")
public class Department extends AbstractEntity{

    @Column(name = "namedepart")
    private String nameDepart;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDepartment")
    private List<Product> products;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDepartment")
    private List<Tools> toolss;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDepartment")
    @JsonIgnoreProperties(value = {"department"}, allowGetters = true)
    private List<User> users;
}