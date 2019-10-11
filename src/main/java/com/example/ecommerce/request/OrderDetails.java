package com.example.ecommerce.request;

import com.example.ecommerce.model.CardInfo;
import com.example.ecommerce.model.Cart;
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
