package com.nwa.intraservice.repository;

import com.nwa.intraservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
}
