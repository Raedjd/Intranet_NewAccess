package com.nwa.intraservice.repository;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolsRepository extends JpaRepository<Tools, Long> {

       @Query("SELECT  T FROM Tools  T JOIN  T.department D WHERE D.id=?1")
        List<Tools> toolsByDep(Long idDep);
}
