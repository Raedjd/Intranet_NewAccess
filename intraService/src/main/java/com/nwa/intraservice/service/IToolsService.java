package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.Event;
import com.nwa.intraservice.models.Tools;

import java.util.List;

public interface IToolsService {

    void addToolsAndAssignToUserAndToDepartment(Tools tools , Long idUser ,Long idDepartment);

    List<Tools> getToolsByDepartement(Long idDep);

    List<Tools> findAll();

    Tools updateTools(Tools tools, Long id);

    void deleteTools(Long id);





}
