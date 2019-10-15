package com.example.ecommerce.service.products;

import com.example.ecommerce.dal.products.ProductDAOImpl;
import com.example.ecommerce.model.product.Inventory;
import com.example.ecommerce.service.representation.request.products.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductDAOImpl productDAO;

    public String addAllProducts(ProductDetails productDetails) {

        return productDAO.saveProucts(productDetails.getProducts());
    }

    public Inventory findProduct(long productId) {
        return productDAO.lookProduct(productId);

    }

}
