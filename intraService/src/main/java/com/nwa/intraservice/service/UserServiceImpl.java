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
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements IUserService , UserDetailsService {


        @Autowired
        private UserRepository userRepository;
        @Autowired
        private DepartmentRepository departmentRepository;
       @Autowired
       private RoleRepository roleRepository;
    @Autowired
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



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
            user.setPassword(passwordEncoder().encode(user.getPassword()));
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

    @Override
    public User udatePicture(User user,Long id, String url) {

        return null;
    }


    @Override
    public User findByUserByToken(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }
        else{
            log.info("User found in the databse:" , username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        return new org.springframework.security.core.userdetails.User(user.getUsername() , user.getPassword() , authorities);
    }


}