package com.nwa.intraservice.repository;


import com.nwa.intraservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT  P FROM Product  P JOIN  P.department D WHERE D.id=?1")
    List<Product> ProductByDep(Long idDep);
}
