package com.example.ecommerce.model.product;

import com.example.ecommerce.dal.products.ProductDAOImpl;

import java.util.List;

public class ProductManager {

    private ProductDAOImpl productDAO = new ProductDAOImpl();

    public String saveProducts(List<Inventory> products){
        return productDAO.saveProducts(products);
    }

    public Inventory lookProduct(long productID){
        return productDAO.lookProduct(productID);
    }
}
