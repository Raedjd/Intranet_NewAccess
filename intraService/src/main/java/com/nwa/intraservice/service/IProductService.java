package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.Product;
import com.nwa.intraservice.models.Tools;

import java.util.List;

public interface IProductService {

    Product addProduct(Product product);

    void addProductAndAssignToDepartment(Product pd, String nameDepart);

    List<Product> findAll();

    Product findById(Long id);

    List<Product> getProductByDepartement(Long idDep);

    Product updateProduct(Product prod, Long id);
    void deleteProduct(long id);

    Long countProducts();


}
