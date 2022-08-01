package com.nwa.intraservice.service;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.Product;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.DepartmentRepository;
import com.nwa.intraservice.repository.ProductRepository;
import com.nwa.intraservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Product addProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    public void addProductAndAssignToDepartment(Product pd, String nameDepart) {
        Department department = departmentRepository.findDepartmentByNameDepart(nameDepart);
            pd.setDepartment(department);
            productRepository.save(pd);
        }


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getProductByDepartement(Long idDep) {
        return productRepository.ProductByDep(idDep);
    }

    @Override
    public Product updateProduct(Product prod, Long id) {
        if(productRepository.findById(id).isPresent()){
            Product product = productRepository.findById(id).get();
            product.setNameProduct(prod.getNameProduct());
            return productRepository.save(product);
        }

        return null;
    }

    @Override
    public void deleteProduct(long id) {

        productRepository.deleteById(id);

    }

    @Override
    public Long countProducts() {
        return productRepository.getCountProducts();
    }


}
