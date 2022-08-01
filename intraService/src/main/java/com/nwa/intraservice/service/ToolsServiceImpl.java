package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.Event;
import com.nwa.intraservice.models.Tools;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.DepartmentRepository;
import com.nwa.intraservice.repository.ToolsRepository;
import com.nwa.intraservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ToolsServiceImpl implements  IToolsService{

    @Autowired
    ToolsRepository toolsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public void addToolsAndAssignToUserAndToDepartment(Tools tools, String nameDepart) {
        Department department = departmentRepository.findDepartmentByNameDepart(nameDepart);
        tools.setDepartment(department);
        toolsRepository.save(tools);

    }

    @Override
    public List<Tools> getToolsByDepartement(Long idDep) {
        return toolsRepository.toolsByDep(idDep);
    }

    @Override
    public List<Tools> findAll() {
        return toolsRepository.findAll();
    }

    @Override
    public Tools updateTools(Tools tools, Long id) {
        if(toolsRepository.findById(id).isPresent()) {
           Tools t = toolsRepository.findById(id).get();
            t.setNameTools(tools.getNameTools());
            t.setNbrTools(tools.getNbrTools());
            return toolsRepository.save(t);
        }
        return null;
    }

    @Override
    public void deleteTools(Long id) {
           toolsRepository.deleteById(id);
    }

    @Override
    public Long countTools() {
        return toolsRepository.getCountTools();
    }
}
