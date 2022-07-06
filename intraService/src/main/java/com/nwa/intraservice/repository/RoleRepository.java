package com.nwa.intraservice.repository;

import com.nwa.intraservice.models.Role;
import com.nwa.intraservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
