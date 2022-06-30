package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.Product;
import com.nwa.intraservice.repository.DepartmentRepository;
import com.nwa.intraservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void addProductAndAssignToDepartment(List<Product> pd, Long idDep) {
        Department department = departmentRepository.findById(idDep).orElse(null);

        for (Product product: pd){
            product.setDepartment(department);
            productRepository.save(product);
        }
    }
}
