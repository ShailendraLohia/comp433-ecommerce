package com.example.ecommerce.service.shipping;

import com.example.ecommerce.service.shipping.representation.ShippingDetails;
import com.example.ecommerce.service.shipping.representation.response.ShippingDetailsResponse;

public interface ShippingService {
    public ShippingDetailsResponse createShippingInformation(ShippingDetails shippingDetails);
    public String getShippingStatus(String trackingNumber);
    public String updateShippingStatus(ShippingDetails shippingDetails);
}
