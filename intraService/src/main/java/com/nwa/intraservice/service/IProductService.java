package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.Product;

import java.util.List;

public interface IProductService {

    Product addProduct(Product product);

    void addProductAndAssignToDepartment(List<Product> pd, Long idDep);

    List<Product> findAll();

    Product findById(Long id);

    Product updateProduct(Product prod, Long id);
    void deleteProduct(long id);


}
