package com.nwa.intraservice.controller;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.Product;
import com.nwa.intraservice.models.Role;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.service.IUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api("/user")
@Slf4j
public class UserRestController {
    @Autowired
    IUserService iUserService;

    @PostMapping("/add")
    @ResponseBody
    public User add(@RequestBody User u) {
        User user = iUserService.addUser(u);

        return user;

    }

    @PostMapping("/addrole")
    @ResponseBody
    public Role add(@RequestBody Role r) {
        Role role = iUserService.addRole(r);

        return role;

    }

    @PostMapping("/add/{idDep}/{idRole}")
    @ResponseBody
    public void addUserAndAssignToDep(@RequestBody List<User> user, @PathVariable("idDep") Long idDepartemnt ,@PathVariable("idRole") Long idRole){
        iUserService.addUserAndAssignToDepartment(user ,idDepartemnt, idRole);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<User> list() {

        return iUserService.findAll();
    }

    @GetMapping("/findOne/{id}")
    @ResponseBody
    public User findById(@PathVariable("id") Long id) {
        return iUserService.findById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public User modify(@RequestBody User u,@PathVariable("id") Long id) {
        return iUserService.updateUser(u ,id);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") Long id) {
        iUserService.deleteUser(id);

    }




}
