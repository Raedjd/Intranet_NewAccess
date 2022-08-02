package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Comment;
import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.Post;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.CommentRepository;
import com.nwa.intraservice.repository.PostRepository;
import com.nwa.intraservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentServiceImpl implements  ICommentService{

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;
    @Override
    public void addCommentAndAssignToPostByUser(Comment comment, Long idUser, Long idPost) {
        User user= userRepository.findById(idUser).orElse(null);
        Post post= postRepository.findById(idPost).orElse(null);

        comment.setUser(user);
        comment.setPost(post);
        commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment, Long id) {

        if(commentRepository.findById(id).isPresent()) {
            Comment c = commentRepository.findById(id).get();
            c.setComment(comment.getComment());
            return commentRepository.save(c);
        }
        return null;
    }

    @Override
    public List<Comment> FindAll() {
        return commentRepository.findAll();
    }

    @Override
    public void deleteComment(Long id) {
            commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> getCommentByPost(Long idPost) {
        return commentRepository.CommentByPost(idPost);
    }
}
