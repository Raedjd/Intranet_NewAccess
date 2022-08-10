package com.nwa.intraservice.controller;

import com.nwa.intraservice.models.Post;
import com.nwa.intraservice.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostRestController {

    @Autowired
    IPostService iPostService;

    @PostMapping("/add/{id}")
    @ResponseBody
    public void addPostByUser(@RequestBody List<Post> post, @PathVariable("id") Long idUser){
    iPostService.addPostByUser(post , idUser);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Post modify(@RequestBody Post post,@PathVariable("id") Long id) {
        return iPostService.updatePost(post , id);

    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<Post> list() {

        return iPostService.FindAll();
    }

    @GetMapping("/countposts")
    public Long countUsers() {
        return iPostService.countPosts();
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") Long id) {
        iPostService.deletePost(id);

    }

}
