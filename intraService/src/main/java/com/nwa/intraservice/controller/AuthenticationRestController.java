package com.nwa.intraservice.controller;


import com.nwa.intraservice.config.security.TokenProvider;
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
    private Object response;

//    @PostMapping("login/{isRemembered}")
//    public ResponseEntity<?> authenticate(@RequestBody LoginModel loginModel, @PathVariable("isRemembered") boolean isRemembered){


    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginModel loginModel ,       HttpServletResponse response ){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginModel.getUsername(),
                        loginModel.getPassword()
                )
        );


        UserDetails userDetails = userDetailsService.loadUserByUsername(loginModel.getUsername());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token;


        token = tokenProvider.generateToken(userDetails,1);

        Cookie cookie = new Cookie("jwt", token);
        response.addCookie(cookie);
        return ResponseEntity.ok(new JwtRespone(token));
    }



}