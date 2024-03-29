package com.nwa.intraservice.controller;

import com.nwa.intraservice.models.Product;
import com.nwa.intraservice.service.IDepartmentService;
import com.nwa.intraservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
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
    @PostMapping("/add/{nameDep}")
    @ResponseBody
    public void addProdAndAssignToDep(@RequestBody Product prod,@PathVariable("nameDep") String nameDepart){
        iProductService.addProductAndAssignToDepartment(prod ,nameDepart);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<Product> list() {

        return iProductService.findAll();
    }

    @GetMapping("/findOne/{id}")
    @ResponseBody
    public Product findById(@PathVariable("id") Long id) {

        return iProductService.findById(id);
    }

    @GetMapping("/productbydepart/{iddepart}")
    public List<Product> getProductsByDEpart(@PathVariable("iddepart") Long iddep) {
        return iProductService.getProductByDepartement(iddep);
    }

    @GetMapping("/countproducts")
    public Long countUsers() {
        return iProductService.countProducts();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Product modify(@RequestBody Product prod,@PathVariable("id") Long id) {
        return iProductService.updateProduct(prod ,id);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") Long id) {
        iProductService.deleteProduct(id);
    }
}
