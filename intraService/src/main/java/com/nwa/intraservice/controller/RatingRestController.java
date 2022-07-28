package com.nwa.intraservice.controller;

import com.nwa.intraservice.models.Event;
import com.nwa.intraservice.models.Product;
import com.nwa.intraservice.models.Rating;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.service.IProductService;
import com.nwa.intraservice.service.IRatingService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/rating")
@Api("/rating")
@Slf4j
public class RatingRestController {

    @Autowired
    IRatingService iRatingService;

    @PostMapping("/add/{idUser}/{idEvent}")
    @ResponseBody
    public void addRatingAndAssignToEvent(@RequestBody Rating rating, @PathVariable("idUser") Long idUser, @PathVariable("idEvent") Long idEvent){
   iRatingService.addRatingByUserAndAssignToEvent(rating ,idUser ,idEvent);
    }

    @GetMapping("/ratingbyevent/{idEvent}")
    public List<Rating> getRatingsByEvent(@PathVariable("idEvent") Long idEvent) {
        return iRatingService.getRatingByEvent(idEvent);
    }

    @GetMapping("/ratingbyuser/{idUser}")
    public List<Rating> getRatingsByUser(@PathVariable("idUser") Long idUser) {
        return iRatingService.getRatingByUser(idUser);
    }
}
