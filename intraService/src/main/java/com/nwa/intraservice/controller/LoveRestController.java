
package com.nwa.intraservice.controller;

import com.nwa.intraservice.models.Love;
import com.nwa.intraservice.service.ILoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/love")
public class LoveRestController {

    @Autowired
    ILoveService iLoveService;

    @PostMapping("/add/{idUser}/{idPost}")
    @ResponseBody
    public void addLikeAndAssignToEvent(@RequestBody Love love, @PathVariable("idUser") Long idUser, @PathVariable("idPost") Long idPost){
        iLoveService.addLikeByUserAndAssignToPost(love,idUser,idPost);
    }

    @PostMapping("/unlove/{idUser}/{idPost}")
    @ResponseBody
    public void unLove(@RequestBody Love love, @PathVariable("idUser") Long idUser, @PathVariable("idPost") Long idPost){
        iLoveService.unLove(love, idUser, idPost);
    }

    @GetMapping("/lovebypost/{idPost}")
    public List<Love> getLovesByPost(@PathVariable("idPost") Long idPost) {
        return iLoveService.getLoveByPost(idPost);
    }



}

