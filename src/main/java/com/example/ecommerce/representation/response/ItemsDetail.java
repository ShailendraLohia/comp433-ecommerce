package com.example.ecommerce.representation.response;

import com.example.ecommerce.model.order.SoldProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemsDetail {
    private String cartId;
    private List<SoldProduct> itemsSold;
}
