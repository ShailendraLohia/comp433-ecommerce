package com.example.ecommerce.service.shipping;

import com.example.ecommerce.service.shipping.representation.ShippingDetails;

public interface ShippingService {
    public String createShippingInformation(ShippingDetails shippingDetails);
}
