package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.Product;

import java.util.List;

public interface IProductService {

    Product addProduct(Product product);

    void addProductAndAssignToDepartment(List<Product> pd, Long idDep);
}
