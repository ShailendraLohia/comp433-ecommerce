package com.example.ecommerce.service.representation.request.shipping;

import com.example.ecommerce.model.order.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingDetails {
    private Cart cart;
}