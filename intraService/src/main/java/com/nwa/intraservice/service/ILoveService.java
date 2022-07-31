
package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Love;

public interface ILoveService {

    void addLikeByUserAndAssignToPost(Love love, Long idUser , Long idPost);
}

