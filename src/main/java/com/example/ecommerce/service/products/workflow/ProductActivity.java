package com.example.ecommerce.service.products.workflow;

import com.example.ecommerce.dal.products.ProductDAOImpl;
import com.example.ecommerce.model.Link;
import com.example.ecommerce.model.product.Inventory;
import com.example.ecommerce.model.product.ProductManager;
import com.example.ecommerce.service.products.ProductService;
import com.example.ecommerce.service.products.representation.ProductDetails;
import com.example.ecommerce.service.products.representation.ProductRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductActivity implements ProductService {

    @Autowired
    private ProductManager productManager;// = new ProductManager();

    public String addAllProducts(ProductDetails productDetails) {
        return productManager.saveProducts(productDetails.getProducts());
    }

    public ProductRepresentation findProduct(long productId) {

        Inventory inventory=productManager.lookProduct(productId);
        ProductRepresentation productRepresentation=new ProductRepresentation();
        productRepresentation.setItem_price(inventory.getItem_price());
        productRepresentation.setItem_quantity_available(inventory.getItem_quantity_available());
        productRepresentation.setItem_category(inventory.getItem_category());
        productRepresentation.setItem_id(inventory.getItem_id());
        productRepresentation.setItem_name(inventory.getItem_name());

        setLinks(productRepresentation);
        return productRepresentation;
    }

    private void setLinks(ProductRepresentation productRepresentation) {
        Link buy = new Link("buy", "http://localhost:8080/services/order/orders");

        productRepresentation.setLinks(buy);
    }
}
