package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Comment;
import com.nwa.intraservice.models.Post;

import java.util.List;

public interface IPostService {

    void addPostByUser(List<Post> post , Long idUser );

    Post updatePost(Post post, Long id);

    List<Post> FindAll();

    void deletePost( Long id);
}
