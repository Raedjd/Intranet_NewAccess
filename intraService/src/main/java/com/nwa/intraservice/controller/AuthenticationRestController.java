
package com.nwa.intraservice.controller;


import com.nwa.intraservice.config.security.TokenProvider;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.UserRepository;
import com.nwa.intraservice.service.UserServiceImpl;
import com.nwa.intraservice.utils.JwtRespone;
import com.nwa.intraservice.utils.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthenticationRestController {

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserServiceImpl userDetailsService;


    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginModel loginModel ,       HttpServletResponse response ){
        User user=userRepository.findByUsername(loginModel.getUsername());

        if(user.getIsBlocked().equals(false)) {
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginModel.getUsername(),
                            loginModel.getPassword()
                    )
            );


            UserDetails userDetails = userDetailsService.loadUserByUsername(loginModel.getUsername());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token;


            token = tokenProvider.generateToken(userDetails, 1);

            Cookie cookie = new Cookie("jwt", token);
            response.addCookie(cookie);
            return ResponseEntity.ok(new JwtRespone(token));
        }
        else{
            return ResponseEntity.ok("Your account is blocked!");
        }
    }



}
