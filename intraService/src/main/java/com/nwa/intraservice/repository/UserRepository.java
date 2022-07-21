package com.nwa.intraservice.repository;

import com.nwa.intraservice.models.Product;
import com.nwa.intraservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

     User findByUsername(String username);
     User findByMail(String mail);

     @Query("SELECT  U FROM User  U JOIN  U.department D WHERE D.id=?1")
     List<User> UserByDep(Long idDep);



}
