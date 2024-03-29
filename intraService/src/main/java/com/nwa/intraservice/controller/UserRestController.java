package com.nwa.intraservice.controller;

import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.UserRepository;
import com.nwa.intraservice.service.IUserService;
import com.nwa.intraservice.service.UserServiceImpl;
import com.nwa.intraservice.utils.ChangePasswordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")

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



    @PostMapping("/add/{nameDep}")
    @ResponseBody
    public ResponseEntity addUserAndAssignToDep(@RequestBody User user, @PathVariable("nameDep") String nameDepart) {
            User username=userRepository.findByUsername(user.getUsername());
        User mail=userRepository.findByMail(user.getMail());
          if( username !=null ) {
              return   ResponseEntity.ok("Username alerady exist");

          }
        if( mail !=null ) {
            return   ResponseEntity.ok("Mail alerady exist");

        }

        iUserService.addUserAndAssignToDepartment(user, nameDepart);
        return   ResponseEntity.ok("New user added in New Access");


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
    @GetMapping("/userbydepart/{iddepart}")
    public List<User> getUsersByDEpart(@PathVariable("iddepart") Long iddep) {
        return iUserService.getUserByDepartement(iddep);
    }

    @PutMapping("/blocked/{id}")
    @ResponseBody
    public User userBlocked(@RequestBody User user, @PathVariable("id") Long id) {
        return iUserService.userBlocked(user ,id);
    }

    @GetMapping("/countusers")
    public Long countUsers() {
        return iUserService.countUsers();
    }
    @Autowired
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @PutMapping("/changepwd/{id}")
    @ResponseBody
    public ResponseEntity changepwd(@RequestBody ChangePasswordModel changePasswordModel, @PathVariable("id") Long id) {

            User u=userRepository.findById(id).orElse(null);
            Boolean isTrue =passwordEncoder.matches(changePasswordModel.getOldPassword(), u.getPassword());
            if(isTrue) {
                System.out.print(isTrue);
                u.setPassword(passwordEncoder().encode(changePasswordModel.getNewPassword()));
                userRepository.save(u);
                return ResponseEntity.ok("Password changed");
            }
        return  ResponseEntity.ok("Old password invalid!");
    }

}
