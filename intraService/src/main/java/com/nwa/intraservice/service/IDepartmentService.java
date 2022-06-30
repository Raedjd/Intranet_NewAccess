package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Department;

import java.util.List;

public interface IDepartmentService {

    Department addDepartment(Department dep);
    List<Department> findAll();
    Department findById(Long id);
    Department updateDepartment(Department dep, Long id);
    void deleteDepartment(long id);


}
