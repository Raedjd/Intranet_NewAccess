package com.nwa.intraservice.service;


import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.Image;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.DepartmentRepository;
import com.nwa.intraservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements IUserService , UserDetailsService {


        @Autowired
        private UserRepository userRepository;
        @Autowired
        private DepartmentRepository departmentRepository;

    @Autowired
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Override
    public User addUser(User user) {
        String avatar="https://cdn.icon-icons.com/icons2/2643/PNG/512/male_boy_person_people_avatar_icon_159358.png";
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        user.setImage(new Image("",avatar,""));
        return userRepository.save(user);
    }


    @Override
    public Response addUserAndAssignToDepartment(User user, String nameDepart ) {
        Department department = departmentRepository.findDepartmentByNameDepart(nameDepart);
         user.setDepartment(department);
            String avatar="https://cdn.icon-icons.com/icons2/2643/PNG/512/male_boy_person_people_avatar_icon_159358.png";
            user.setPassword(passwordEncoder().encode(user.getPassword()));
            user.setImage(new Image("",avatar,""));
            userRepository.save(user);

        return null;
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
    public List<User> getUserByDepartement(Long idDep) {
        return userRepository.UserByDep(idDep);
    }

    @Override
    public Long countUsers() {
        return  userRepository.getCountUsers();
    }

    @Override
    public Response ChangePassword(User user, Long id) {



            User u = userRepository.findById(id).orElse(null);
            u.setPassword(passwordEncoder().encode(user.getPassword()));
            return (Response) userRepository.save(u);

    }

    @Override
    public User userBlocked(User user, Long id) {
        if (userRepository.findById(id).isPresent()) {
            User u = userRepository.findById(id).get();
            u.setIsBlocked(user.getIsBlocked());
            return userRepository.save(u);
        }
        return null;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        return new org.springframework.security.core.userdetails.User(user.getUsername() , user.getPassword() , authorities);
    }


}