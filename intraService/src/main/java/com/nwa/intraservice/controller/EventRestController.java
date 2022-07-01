package com.nwa.intraservice.controller;


import com.nwa.intraservice.models.Event;
import com.nwa.intraservice.models.Product;
import com.nwa.intraservice.service.IEventService;
import com.nwa.intraservice.service.IUserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@Slf4j
public class EventRestController {
 @Autowired
    private IEventService iEventService;

    @PostMapping("/add/{id}")
    @ResponseBody
    public void addEventAndAssignToUser(@RequestBody List<Event> event, @PathVariable("id") Long iduser){
       iEventService.addEventAndAssignToUser(event , iduser);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<Event> list() {

        return iEventService.findAll();
    }


}
