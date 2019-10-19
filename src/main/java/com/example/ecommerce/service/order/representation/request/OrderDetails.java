package com.example.ecommerce.service.order.representation.request;

import com.example.ecommerce.model.payment.CardInfo;
import com.example.ecommerce.model.order.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    private Cart orderDetails;
    private CardInfo paymentDetails;
}
