package com.nwa.intraservice.repository;

import com.nwa.intraservice.models.Event;
import com.nwa.intraservice.models.Rating;
import com.nwa.intraservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT  R FROM Rating  R JOIN  R.event E WHERE E.id=?1 ")
    List<Rating> RatingByEvent (Long idEvent);

    @Query("SELECT  R FROM Rating  R JOIN  R.user U WHERE U.id=?1 ")
    List<Rating> RatingByUser (Long idUser);



}
