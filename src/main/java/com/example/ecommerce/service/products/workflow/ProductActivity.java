package com.example.ecommerce.service.products.workflow;

import com.example.ecommerce.dal.products.ProductDAOImpl;
import com.example.ecommerce.model.product.Inventory;
import com.example.ecommerce.model.product.ProductManager;
import com.example.ecommerce.service.products.ProductService;
import com.example.ecommerce.service.products.representation.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductActivity implements ProductService {

    @Autowired
    private ProductManager productManager;

    public String addAllProducts(ProductDetails productDetails) {

        return productManager.saveProducts(productDetails.getProducts());
    }

    public Inventory findProduct(long productId) {
        return productManager.lookProduct(productId);

    }

}
