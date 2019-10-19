package com.example.ecommerce.service.workflow.shipping;

import com.example.ecommerce.dal.shipping.ShippingDAOImpl;
import com.example.ecommerce.service.representation.request.shipping.ShippingDetails;
import com.example.ecommerce.service.shipping.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingActivity implements ShippingService {

    @Autowired
    private ShippingDAOImpl shippingDAO;

    public String createShippingInformation(ShippingDetails shippingDetails) {

        return shippingDAO.saveShippingInfo(shippingDetails.getShippingDetails());

    }
}
