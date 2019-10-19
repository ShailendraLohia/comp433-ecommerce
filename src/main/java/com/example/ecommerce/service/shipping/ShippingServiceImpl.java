package com.example.ecommerce.service.shipping;

import com.example.ecommerce.dal.shipping.ShippingDAOImpl;
import com.example.ecommerce.service.representation.request.shipping.ShippingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingServiceImpl {

    @Autowired
    private ShippingDAOImpl shippingDAO;

    public String createShippingInformation(ShippingDetails shippingDetails) {

        return shippingDAO.saveShippingInfo(shippingDetails.getShippingDetails());

    }
}
