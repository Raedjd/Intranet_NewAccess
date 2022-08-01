package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Event;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.DepartmentRepository;
import com.nwa.intraservice.repository.EventRepository;
import com.nwa.intraservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class EventServiceImpl implements IEventService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;

    @Override
    public void addEvent(Event e) {
        eventRepository.save(e);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event findById(Long id) {
        {
            return eventRepository.findById(id).get();
        }
    }


    @Override
    public Event updateEvent(Event event, Long id) {
        if (eventRepository.findById(id).isPresent()) {
            Event e = eventRepository.findById(id).get();
            e.setTitle(event.getTitle());
            e.setDescription(event.getDescription());
            e.setStartDate(event.getStartDate());
            e.setEndDate(event.getEndDate());
            return eventRepository.save(e);
        }
        return null;
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public void UserPartEvent(Long idUser, List<Long> idEvents) {

        User user = userRepository.findById(idUser).orElse(null);

        for (Long idEvent : idEvents) {
            Event event = eventRepository.findById(idEvent).orElse(null);
            event.getUsers().add(user);
        }
    }

    @Override
    public void UserToEvent(Long idUser, Long idEvent) {
        User user = userRepository.findById(idUser).orElse(null);
        Event event = eventRepository.findById(idEvent).orElse(null);

        event.getUsers().add(user);
        eventRepository.save(event);

    }

    @Override
    public Event eventDone(Event event, Long id) {
        if (eventRepository.findById(id).isPresent()) {
            Event e = eventRepository.findById(id).get();
            e.setDone(event.getDone());
            return eventRepository.save(e);
        }
        return null;
    }

    @Override
    public Long countEvents() {
        return eventRepository.getCountEvents();
    }
}