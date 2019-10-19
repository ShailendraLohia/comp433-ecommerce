package com.example.ecommerce.service.products.representation;

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
}
