package com.adminPanel.app.controller;

import com.adminPanel.app.dao.ProductDaoImp;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestHomeController {

    private final ProductDaoImp productDaoImp;

    @Autowired
    public RestHomeController(ProductDaoImp productDaoImp) {
        this.productDaoImp = productDaoImp;
    }

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> listProducts() {
       return productDaoImp.findAll();
    }
    @PostMapping("/product")
    public ProductDetails processAddProduct(ProductDetails product) {
        productDaoImp.save(product);
        return product;
    }
    @DeleteMapping ("/product")
    public String processDeleteProduct(@RequestParam int id) {
        productDaoImp.delete(id);
        return "Product deleted";
    }
    @GetMapping("/product/details")
    public ProductDetails ViewDetails(@RequestParam int id) {
        return productDaoImp.getProductById(id).getProductDetails();
    }
    @PutMapping("/product/details")
    public ProductDetails updateProduct(@RequestBody ProductDetails productDetails){
        productDaoImp.update(productDetails);
        return productDetails;
    }
}
