package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

import java.util.List;

public interface ProductDao {

     List<Product> findAll();
     Product findById(int id);
     void save(ProductDetails productDetails);
    void update(ProductDetails productDetails);
    void delete(int id);
    Product getProductById(int id);
}
