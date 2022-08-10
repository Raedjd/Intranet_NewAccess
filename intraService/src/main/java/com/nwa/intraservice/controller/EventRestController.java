package com.nwa.intraservice.controller;


import com.nwa.intraservice.models.Event;
import com.nwa.intraservice.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventRestController {
 @Autowired
    private IEventService iEventService;

    @PostMapping("/add")
    @ResponseBody
    public void addEventAndAssignToUser(@RequestBody Event event){
       iEventService.addEvent(event );
    }

   @GetMapping("/findAll")
   @ResponseBody
   public List<Event> list() {

      return iEventService.findAll();
   }

    @GetMapping("/findOne/{id}")
    @ResponseBody
    public Event findById(@PathVariable("id") Long id) {
        return iEventService.findById(id);
    }

    @GetMapping("/countevents")
    public Long countUsers() {
        return iEventService.countEvents();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Event modify(@RequestBody Event event,@PathVariable("id") Long id) {
        return iEventService.updateEvent(event , id);
    }
    @PutMapping("/done/{id}")
    @ResponseBody
    public Event eventdone(@RequestBody Event event,@PathVariable("id") Long id) {
        return iEventService.eventDone(event ,id);
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
