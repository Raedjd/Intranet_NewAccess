package com.nwa.intraservice.service;

import com.nwa.intraservice.models.User;

import java.util.List;

public interface IUserService {

    User addUser(User user);

    void addUserAndAssignToDepartment(List<User> u, Long idDep);
    List<User> findAll();
    User findById(Long id);
    User updateUser(User user, Long id);
    void deleteUser(long id);



}
