package com.nwa.intraservice.controller;

import com.nwa.intraservice.models.Role;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.UserRepository;
import com.nwa.intraservice.service.IUserService;
import com.nwa.intraservice.service.UserServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api("/user")
@Slf4j
public class UserRestController {
    @Autowired
    IUserService iUserService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserServiceImpl userDetailsService;

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
    public ResponseEntity<Map> addUserAndAssignToDep(@RequestBody User user, @PathVariable("idDep") Long idDepartemnt , @PathVariable("idRole") Long idRole){
            User username=userRepository.findByUsername(user.getUsername());
          if( username ==null ) {
              iUserService.addUserAndAssignToDepartment(user, idDepartemnt, idRole);
              return new ResponseEntity("User created and assigned", HttpStatus.CREATED);

          }
        return new ResponseEntity("User alerady exist", HttpStatus.FOUND);

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
    @RequestMapping(value = "findByToken", method = RequestMethod.GET)
    public User findUserByToken() {
        return iUserService.findByUserByToken(SecurityContextHolder.getContext().getAuthentication().getName());
    }




}
