package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Event;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.DepartmentRepository;
import com.nwa.intraservice.repository.EventRepository;
import com.nwa.intraservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class EventServiceImpl implements IEventService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;
    @Override
    public void addEventAndAssignToUser(List<Event> e, Long iduser) {
        User u = userRepository.findById(iduser).orElse(null);

        for(Event event:e){
            event.setUser(u);
            eventRepository.save(event);
        }



    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event updateEvent(Event event, Long id) {
        if(eventRepository.findById(id).isPresent()) {
            Event e = eventRepository.findById(id).get();
            e.setTitle(event.getTitle());
            e.setDescription(event.getDescription());
            e.setStartDate(event.getStartDate());
            e.setEndDate(event.getEndDate());
            e.setLastUpdateDate(LocalDate.now());
            return eventRepository.save(e);
        }
        return null;
    }

    @Override
    public void deleteEvent(Long id) {

    }
}
