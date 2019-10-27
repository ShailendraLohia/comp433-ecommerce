package com.example.ecommerce.service.shipping.workflow;

import com.example.ecommerce.dal.shipping.ShippingDAOImpl;
import com.example.ecommerce.exceptions.CartNotFoundException;
import com.example.ecommerce.service.shipping.representation.ShippingDetails;
import com.example.ecommerce.service.shipping.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShippingActivity implements ShippingService {

    @Autowired
    private ShippingDAOImpl shippingDAO;

    public String createShippingInformation(ShippingDetails shippingDetails) {
        if(shippingDetails.getShippingDetails().getCart()==null)
            throw new CartNotFoundException("Your Order is not available with us!");

        return shippingDAO.saveShippingInfo(shippingDetails.getShippingDetails());

    }

    public String getShippingStatus(String trackingNumber) {
        Optional<String> resultStatus=shippingDAO.fetchShippingStatus(trackingNumber);

        if(!resultStatus.isPresent()) {//means tracking number doesn't exist
            throw new CartNotFoundException("Your Order is not available with us!");
        }
        return resultStatus.get();
    }

    public String updateShippingStatus(ShippingDetails shippingDetails) {
        if(shippingDetails.getShippingDetails().getCart()==null)
            throw new CartNotFoundException("Your Order is not available with us!");

        //Validate tracking number
        getShippingStatus(shippingDetails.getShippingDetails().getTrackingNumber());

        return shippingDAO.modifyStatus(shippingDetails.getShippingDetails()).get();
    }
}
