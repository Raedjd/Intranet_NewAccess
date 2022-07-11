package com.nwa.intraservice.repository;

import com.nwa.intraservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

     User findByUsername(String username);
     User findByMail(String mail);



}
