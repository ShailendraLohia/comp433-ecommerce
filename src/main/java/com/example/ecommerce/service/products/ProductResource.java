package com.example.ecommerce.service.products;

import com.example.ecommerce.model.product.Inventory;
import com.example.ecommerce.service.representation.request.products.ProductDetails;
import com.example.ecommerce.service.workflow.products.ProductActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Controller("productService")
@Path("/products")
public class ProductResource {

    @Autowired
    private ProductActivity productServiceImpl;

    @POST
    public ResponseEntity<String> addProducts(@RequestBody ProductDetails productDetails) {

        return new ResponseEntity<>(productServiceImpl.addAllProducts(productDetails),
                HttpStatus.CREATED);
    }

    @GET
    @Path("/{productId}")
    public ResponseEntity<Inventory> searchProduct(@PathParam("productId") long productId) {
        return new ResponseEntity<>(productServiceImpl.findProduct(productId),HttpStatus.ACCEPTED);
    }
}
