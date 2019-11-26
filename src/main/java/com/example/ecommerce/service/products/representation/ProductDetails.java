package com.example.ecommerce.service.products.representation;

import com.example.ecommerce.model.product.Inventory;
import com.example.ecommerce.service.AbstractRepresentation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class ProductDetails extends AbstractRepresentation {
    private List<Inventory> products;

    public List<Inventory> getProducts() {
        return products;
    }
}
