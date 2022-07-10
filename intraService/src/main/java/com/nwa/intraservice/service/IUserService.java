package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Role;
import com.nwa.intraservice.models.User;

import java.util.List;

public interface IUserService {

    User addUser(User user);

    Role addRole(Role role);

    void addUserAndAssignToDepartment(List<User> u, Long idDep ,Long idRole);
    List<User> findAll();
    User findById(Long id);
    User updateUser(User user, Long id);
    void deleteUser(long id);

    User findByUserByToken(String username);



}
