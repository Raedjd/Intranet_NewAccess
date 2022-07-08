package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.Role;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.DepartmentRepository;
import com.nwa.intraservice.repository.RoleRepository;
import com.nwa.intraservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements IUserService  {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RoleRepository roleRepository;






    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addUserAndAssignToDepartment(List<User> u, Long idDep , Long idRole) {
        Department department = departmentRepository.findById(idDep).orElse(null);
        Role role = roleRepository.findById(idRole).orElse(null);
        for(User user:u){
            user.setDepartment(department);
            user.setRole(role);

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
