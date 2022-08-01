
package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Love;
import com.nwa.intraservice.models.Post;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.LoveRepository;
import com.nwa.intraservice.repository.PostRepository;
import com.nwa.intraservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoveServiceImpl implements  ILoveService {
    @Autowired
    LoveRepository loveRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @Override
    public void addLikeByUserAndAssignToPost(Love love, Long idUser, Long idPost) {

        User user=userRepository.findById(idUser).orElse(null);
        Post post=postRepository.findById(idPost).orElse(null);
        love.setUser(user);
        love.setPost(post);
        loveRepository.save(love);
    }

    @Override
    public void unLove(Love love, Long idUser, Long idPost) {
        Post post=postRepository.findById(idPost).orElse(null);
        User user=userRepository.findById(idUser).orElse(null);
        love.setPost(post);
        love.setUser(user);
        loveRepository.save(love);
    }

    @Override
    public List<Love> getLoveByPost(Long idPost) {
        return loveRepository.LoveByPost(idPost);
    }
}

