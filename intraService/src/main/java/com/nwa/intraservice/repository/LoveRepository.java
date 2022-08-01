
package com.nwa.intraservice.repository;

import com.nwa.intraservice.models.Love;
import com.nwa.intraservice.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoveRepository  extends JpaRepository<Love, Long> {

    @Query("SELECT  L FROM Love  L JOIN  L.post P WHERE P.id=?1 ")
    List<Love> LoveByPost (Long idLove);

    @Query("SELECT  L FROM Love  L JOIN  L.user U WHERE U.id=?1 ")
    List<Love> LoveByUser (Long idUser);

}

