
package com.nwa.intraservice.controller;

import com.nwa.intraservice.models.Love;
import com.nwa.intraservice.service.ILoveService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/love")
@Api("/rating")
@Slf4j
public class LoveRestController {

    @Autowired
    ILoveService iLoveService;

    @PostMapping("/add/{idUser}/{idPost}")
    @ResponseBody
    public void addLikeAndAssignToEvent(@RequestBody Love love, @PathVariable("idUser") Long idUser, @PathVariable("idPost") Long idPost){
        iLoveService.addLikeByUserAndAssignToPost(love,idUser,idPost);
    }
}

