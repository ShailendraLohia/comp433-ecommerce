package com.example.ecommerce.service.products;

import com.example.ecommerce.model.product.Inventory;
import com.example.ecommerce.service.products.representation.ProductDetails;
import com.example.ecommerce.service.products.representation.ProductRepresentation;
import com.example.ecommerce.service.products.workflow.ProductActivity;
import org.apache.cxf.rs.security.cors.CorsHeaderConstants;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.apache.cxf.rs.security.cors.LocalPreflight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Controller("productService")
@CrossOriginResourceSharing(
        allowOrigins = {"http://localhost:3000"},
        allowCredentials = true,
        allowHeaders = {
                "'Accept': 'application/json'",
                "'Content-Type': 'application/json'"
        }
)
@Path("/products")
public class ProductResource {

    @Context
    private HttpHeaders headers;

    @OPTIONS
    @Path("/{productId}")
    @LocalPreflight
    public Response options(@PathParam("productId") String productID){
        String origin = headers.getOrigin();
        if("http://localhost:3000".equals(origin)) {
            return Response.ok()
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "GET")
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_CREDENTIALS, "true")
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "http://localhost:3000")
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_HEADERS, "Accept")
                    .build();
        }
        else {
            return Response.ok().build();
        }
    }

    @OPTIONS
    @Path("/")
    @LocalPreflight
    public Response options(){
        String origin = headers.getOrigin();
        if("http://localhost:3000".equals(origin)) {
            return Response.ok()
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "POST")
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_CREDENTIALS, "true")
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "http://localhost:3000")
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_HEADERS, "Content-Type")
                    .build();
        }
        else {
            return Response.ok().build();
        }
    }

    @Autowired
    private ProductActivity productServiceImpl;

    @POST
    public ResponseEntity<String> addProducts(@RequestBody ProductDetails productDetails) {

        return new ResponseEntity<>(productServiceImpl.addAllProducts(productDetails),
                HttpStatus.CREATED);
    }

    @GET
    @Path("/{productId}")
    public ResponseEntity<ProductRepresentation> searchProduct(@PathParam("productId") long productId) {
        return new ResponseEntity<>(productServiceImpl.findProduct(productId),HttpStatus.ACCEPTED);
    }
}
