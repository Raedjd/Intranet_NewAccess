package com.nwa.intraservice.repository;

import com.nwa.intraservice.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department ,Long> {

    Department findDepartmentByNameDepart(String name);

    @Query("SELECT COUNT(d) FROM Department d ")
    Long getCountDepartments();
}
