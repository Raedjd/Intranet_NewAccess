package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.DepartmentRepository;
import com.nwa.intraservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void addUserAndAssignToDepartment(List<User> u, Long idDep) {
        Department department = departmentRepository.findById(idDep).orElse(null);

        for(User user:u){
            user.setDepartment(department);
            userRepository.save(user);
        }
    }



    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(User user, Long id) {
        if(userRepository.findById(id).isPresent()) {
            User u = userRepository.findById(id).get();
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setBirthdate(user.getBirthdate());
            u.setNationnality(user.getNationnality());
            u.setPhone(user.getPhone());
            u.setPoste(user.getPoste());
            return userRepository.save(u);
        }
        return null;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }


}
