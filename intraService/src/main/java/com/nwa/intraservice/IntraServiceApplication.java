
package com.nwa.intraservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class IntraServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(IntraServiceApplication.class, args);
    }

    @GetMapping("/c")
    public String raed(){
        return "hello";
    }
}

