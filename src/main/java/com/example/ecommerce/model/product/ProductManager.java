package com.example.ecommerce.model.product;

import com.example.ecommerce.dal.products.ProductDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductManager {

    @Autowired
    private ProductDAOImpl productDAO;// = new ProductDAOImpl();

    public String saveProducts(List<Inventory> products){
        return productDAO.saveProducts(products);
    }

    public Inventory lookProduct(long productID){
        return productDAO.lookProduct(productID);
    }
}
