package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.Post;
import com.nwa.intraservice.models.Product;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.PostRepository;
import com.nwa.intraservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class PostServiceImpl implements IPostService{
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public void addPostByUser(List<Post> post, Long idUser) {

        User user = userRepository.findById(idUser).orElse(null);

        for (Post ps: post){
            ps.setUser(user);
            postRepository.save(ps);
        }

    }

    @Override
    public Post updatePost(Post post, Long id) {

        if(postRepository.findById(id).isPresent()){
            Post ps = postRepository.findById(id).get();
            ps.setDescription(post.getDescription());
            ps.setLastUpdateDate(LocalDate.now());
            return postRepository.save(ps);
        }

        return null;
    }

    @Override
    public List<Post> FindAll() {
        return postRepository.findAll();
    }

    @Override
    public void deletePost(Long id) {
           postRepository.deleteById(id);
    }
}
