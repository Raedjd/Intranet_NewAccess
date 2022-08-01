package com.nwa.intraservice.repository;


import com.nwa.intraservice.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    @Query("SELECT COUNT(u) FROM Post u ")
    Long getCountPosts();
}
