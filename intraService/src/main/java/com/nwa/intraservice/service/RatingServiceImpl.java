package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Event;
import com.nwa.intraservice.models.Rating;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.EventRepository;
import com.nwa.intraservice.repository.RatingRepository;
import com.nwa.intraservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RatingServiceImpl implements  IRatingService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private EventRepository eventRepository;
    @Override
    public void addRatingByUserAndAssignToEvent(Rating rating, Long idUser, Long idEvent) {

        User user=userRepository.findById(idUser).orElse(null);
        Event event=eventRepository.findById(idEvent).orElse(null);
        rating.setUser(user);
        rating.setEvent(event);
        ratingRepository.save(rating);

    }

    @Override
    public List<Rating> getRatingByEvent(Long idEvent) {
        return ratingRepository.RatingByEvent(idEvent);
    }

    @Override
    public List<Rating> getRatingByUser(Long idUser) {
        return ratingRepository.RatingByUser(idUser);
    }
}
