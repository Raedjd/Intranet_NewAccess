
package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Love;
import com.nwa.intraservice.models.Rating;

import java.util.List;

public interface ILoveService {

    void addLikeByUserAndAssignToPost(Love love, Long idUser , Long idPost);
   void unLove(Love love, Long idUser, Long idPost);
    List<Love> getLoveByPost(Long idPost);
}

