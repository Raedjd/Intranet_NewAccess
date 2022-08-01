package com.nwa.intraservice.controller;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.service.IDepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/dep")
@Slf4j
public class DepartmentRestController {
    @Autowired
    IDepartmentService idepService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity add(@RequestBody Department d ) {
        Department dep = idepService.addDepartment(d);

        return ResponseEntity.ok("New department created in New Access");

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
    @GetMapping("/countdepartments")
    public Long countUsers() {
        return idepService.countDepartments();
    }
    @PutMapping("/update/{id}")
    @ResponseBody
    public Department modify(@RequestBody Department dep,@PathVariable("id") Long id) {
        return idepService.updateDepartment(dep, id);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") Long id) {
        idepService.deleteDepartment(id);
        log.info("Department removed!");
    }

}
