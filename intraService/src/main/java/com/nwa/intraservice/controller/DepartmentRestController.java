package com.nwa.intraservice.controller;

import ch.qos.logback.core.status.Status;
import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.service.IDepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/dep")
@Slf4j
public class DepartmentRestController {
    @Autowired
    IDepartmentService idepService;

    @PostMapping("/adddep")
    @ResponseBody
    public Department add(@RequestBody Department d) {
        Department dep = idepService.addDepartment(d);

        return dep;

    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<Department> list() {
        return idepService.findAll();
    }

    @GetMapping("/findOne/{id}")
    @ResponseBody
    public Department findById(@PathVariable("id") Long id) {
        return idepService.findById(id);
    }

    @PutMapping("/updateDep/{id}")
    @ResponseBody
    public Department modify(@RequestBody Department dep,@PathVariable("id") Long id) {
        return idepService.updateDepartment(dep, id);
    }

    @DeleteMapping("deleteDep/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") Long id) {
        idepService.deleteDepartment(id);
        log.info("Department removed!");
    }

}
