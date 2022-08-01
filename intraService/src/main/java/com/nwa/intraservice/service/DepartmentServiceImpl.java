package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private DepartmentRepository  departmentRepository ;

    @Autowired
    private IUserService iUserService;


    @Override
    public Department addDepartment(Department dep) {
        return departmentRepository.save(dep);

    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Department updateDepartment(Department dep, Long id) {
        if(departmentRepository.findById(id).isPresent()){
            Department department = departmentRepository.findById(id).get();
            department.setNameDepart(dep.getNameDepart());
           // department.setLastUpdateDate(LocalDate.now());
            return departmentRepository.save(department);
        }
        return null;
    }

    @Override
    public void deleteDepartment(long id) {
        departmentRepository.deleteById(id);

    }

    @Override
    public Long countDepartments() {
        return departmentRepository.getCountDepartments();
    }


}
