package com.nwa.intraservice.controller;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.Product;
import com.nwa.intraservice.service.IDepartmentService;
import com.nwa.intraservice.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductRestController {
    @Autowired
    IProductService iProductService;
    @Autowired
    IDepartmentService iDepartmentService;
    @PostMapping("/addproduct")
    @ResponseBody
    public Product add(@RequestBody Product p) {
        Product prod = iProductService.addProduct(p);

        return prod;

    }
    @PostMapping("/addproduct/{id}")
    public void addProdAndAssignToDep(@RequestBody List<Product> prod, @PathVariable("id") Long idDepartemnt){
        iProductService.addProductAndAssignToDepartment(prod ,idDepartemnt);
    }
}
