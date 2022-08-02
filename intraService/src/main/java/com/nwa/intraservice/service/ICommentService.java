package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Comment;
import com.nwa.intraservice.models.Love;
import com.nwa.intraservice.models.Post;
import com.nwa.intraservice.models.Tools;

import java.util.List;

public interface ICommentService {

    void addCommentAndAssignToPostByUser(Comment comment , Long idUser , Long idPost);

    Comment updateComment(Comment comment, Long id);

    List<Comment> FindAll();

    void deleteComment(Long id);

    List<Comment> getCommentByPost(Long idPost);


}
