package com.nwa.intraservice.repository;

import com.nwa.intraservice.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
