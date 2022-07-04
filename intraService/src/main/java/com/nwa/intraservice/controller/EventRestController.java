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

    @PutMapping("/update/{id}")
    @ResponseBody
    public Event modify(@RequestBody Event event,@PathVariable("id") Long id) {
        return iEventService.updateEvent(event , id);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") Long id) {
        iEventService.deleteEvent(id);
    }

    @PutMapping("/participation/{idUser}/{idEvents}")
    public void UserParEvent(@PathVariable("idUser")Long idUser, @PathVariable("idEvents")List<Long> idEvents){
        iEventService.UserPartEvent(idUser ,idEvents);
    }

    @PatchMapping("/participation/{iduser}/{idevent}")
    public void UserToEvent(@PathVariable("iduser") Long idUser, @PathVariable("idevent") Long idEvent){
        iEventService.UserToEvent(idUser , idEvent);
    }

}
