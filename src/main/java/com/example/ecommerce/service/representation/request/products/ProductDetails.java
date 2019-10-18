package com.example.ecommerce.service.representation.request.products;

import com.example.ecommerce.model.product.Inventory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class ProductDetails {
    private List<Inventory> products;

    public List<Inventory> getProducts() {
        return products;
    }
}