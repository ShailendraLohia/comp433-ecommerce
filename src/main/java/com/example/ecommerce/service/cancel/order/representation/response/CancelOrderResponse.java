package com.example.ecommerce.service.cancel.order.representation.response;

import com.example.ecommerce.model.cancel.order.ReturnItems;
import com.example.ecommerce.service.AbstractRepresentation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CancelOrderResponse extends AbstractRepresentation {
    private String cartId;
    //private Set<ReturnItems> returnItems;
}
