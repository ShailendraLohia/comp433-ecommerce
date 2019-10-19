package com.example.ecommerce.service.shipping;

import com.example.ecommerce.service.representation.request.shipping.ShippingDetails;

public interface ShippingService {
    public String createShippingInformation(ShippingDetails shippingDetails);
}
