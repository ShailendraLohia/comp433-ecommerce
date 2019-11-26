package com.example.ecommerce.service.shipping.representation;

import com.example.ecommerce.model.shipping.ShippingStatus;
import com.example.ecommerce.service.AbstractRepresentation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingDetails extends AbstractRepresentation {
    private ShippingStatus shippingDetails;
}
