package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Event;
import com.nwa.intraservice.models.Product;

import java.util.List;

public interface IEventService {

    void addEvent(Event e);

    List<Event> findAll();

    Event updateEvent(Event event, Long id);

    void deleteEvent(Long id);

    void UserPartEvent (Long idUser ,List<Long> idEvents);

    void UserToEvent (Long idUser , Long idEvent);
}
