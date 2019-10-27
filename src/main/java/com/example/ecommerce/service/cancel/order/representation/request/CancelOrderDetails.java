package com.example.ecommerce.service.cancel.order.representation.request;

import com.example.ecommerce.model.cancel.order.OrderCancel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CancelOrderDetails {
    private OrderCancel orderCancel;

    public OrderCancel getOrderCancel(){ return orderCancel; }
}
