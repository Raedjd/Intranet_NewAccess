package com.nwa.intraservice.repository;

import com.nwa.intraservice.models.ProductOfDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOfDepartmentRepository extends JpaRepository<ProductOfDepartment, Long> {
}
