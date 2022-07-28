package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Rating;
import com.nwa.intraservice.models.User;

import java.util.List;

public interface IRatingService {

    void addRatingByUserAndAssignToEvent(Rating rating, Long idUser ,Long idEvent);

    List<Rating> getRatingByEvent(Long idEvent);
    List<Rating> getRatingByUser(Long idUser);
}
