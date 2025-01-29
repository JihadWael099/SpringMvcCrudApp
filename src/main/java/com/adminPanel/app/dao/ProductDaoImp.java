package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;

import com.adminPanel.app.model.ProductDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

import static com.mysql.cj.conf.PropertyKey.logger;


@Repository
public class ProductDaoImp implements ProductDao {

    Logger logger = Logger.getLogger(ProductDaoImp.class.getName());
    private final SessionFactory sessionFactory;
    @Autowired
    public ProductDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    @Transactional
    public  List<Product> findAll() {
       Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product", Product.class).getResultList();
    }
    @Override
    @Transactional
    public Product findById(int id) {
        return null;
    }

    @Override
    @Transactional
    public void save(ProductDetails productDetails) {
        Session session = sessionFactory.getCurrentSession();

        Product product = productDetails.getProduct();
        if (product == null) {
            product = new Product(productDetails.getName());
            productDetails.setProduct(product);
        }
        session.save(product);
        session.save(productDetails);
    }





    @Override
    @Transactional
    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product getProduct=session.get(Product.class, id);
        return getProduct;
    }

    @Override
    @Transactional
    public void delete(int id ) {
        Session session = sessionFactory.getCurrentSession();
        Product getProduct=getProductById(id);
        if(getProduct.getProductDetails()!=null ){
            session.delete(getProduct.getProductDetails());
        }
        session.delete(getProduct);
    }
    @Override
    @Transactional
    public void update(ProductDetails productDetails) {
        Session session = sessionFactory.getCurrentSession();
        ProductDetails existingProductDetails = session.get(ProductDetails.class, productDetails.getId());
        if (existingProductDetails == null) {
            throw new IllegalArgumentException("ProductDetails not found with ID: " + productDetails.getId());
        }
        existingProductDetails.setName(productDetails.getName());
        existingProductDetails.setExpirationDate(productDetails.getExpirationDate());
        existingProductDetails.setManufacturer(productDetails.getManufacturer());
        existingProductDetails.setPrice(productDetails.getPrice());
        existingProductDetails.setAvailable(productDetails.getAvailable());
        existingProductDetails.getProduct().setName(existingProductDetails.getName());
        session.update(existingProductDetails);
    }
}
