package com.nwa.intraservice.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name ="product")
public class Product extends AbstractEntity {{}
        @Column(name="nameproduct")
        private String nameProduct;
        private String userid;
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "idDepartment")
        @JsonIgnoreProperties({"department","product"})
        @JsonIgnore
        private Department department;

        public Department getDepartment() {
                return department;
        }

        public void setDepartment(Department department) {
                this.department = department;
        }

        public String getNameProduct() {
                return nameProduct;
        }

        public void setNameProduct(String nameProduct) {
                this.nameProduct = nameProduct;
        }

        public String getUserid() {
                return userid;
        }

        public void setUserid(String userid) {
                this.userid = userid;
        }
}



