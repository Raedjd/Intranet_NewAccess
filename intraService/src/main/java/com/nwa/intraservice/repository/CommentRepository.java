package com.nwa.intraservice.repository;

import com.nwa.intraservice.models.Comment;
import com.nwa.intraservice.models.Love;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT  C FROM Comment  C JOIN  C.post P WHERE P.id=?1 ")
    List<Comment> CommentByPost (Long idPost);
}
