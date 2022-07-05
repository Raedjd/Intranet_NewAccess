package com.nwa.intraservice.controller;

import com.nwa.intraservice.models.Comment;
import com.nwa.intraservice.models.Post;
import com.nwa.intraservice.models.Tools;
import com.nwa.intraservice.service.ICommentService;
import com.nwa.intraservice.service.IToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentRestController {

    @Autowired
    ICommentService iCommentService;

    @PostMapping("/add/{idUser}/{idPost}")
    public void addCommentAndAssignToPostbyUser(@RequestBody Comment comment, @PathVariable("idUser") Long idUser,
                                                @PathVariable("idPost") Long idPost) {
        iCommentService.addCommentAndAssignToPostByUser(comment ,idUser ,idPost);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Comment modify(@RequestBody Comment comment, @PathVariable("id") Long id) {
        return iCommentService.updateComment(comment , id);

    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<Comment> list() {

        return iCommentService.FindAll();
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") Long id) {
        iCommentService.deleteComment(id);

    }
}
