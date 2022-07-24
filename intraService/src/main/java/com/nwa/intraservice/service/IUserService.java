package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Product;
import com.nwa.intraservice.models.Role;
import com.nwa.intraservice.models.User;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.Response;
import java.util.List;

public interface IUserService {

    User addUser(User user);

    Role addRole(Role role);

    Response addUserAndAssignToDepartment(User user, String nameDepart );
    List<User> findAll();
    User findById(Long id);
    User updateUser(User user, Long id);
    void deleteUser(long id);

     User udatePicture (User user,Long id , String url );
    User findByUserByToken(String username);

    List<User> getUserByDepartement(Long idDep);

   Response ChangePassword(User user,Long id);

}
