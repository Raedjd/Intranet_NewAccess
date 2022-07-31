
package com.nwa.intraservice.repository;

import com.nwa.intraservice.models.Love;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoveRepository  extends JpaRepository<Love, Long> {
}

