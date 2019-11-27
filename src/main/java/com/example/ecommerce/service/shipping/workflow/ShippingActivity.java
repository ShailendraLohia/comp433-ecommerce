package com.example.ecommerce.service.shipping.workflow;

import com.example.ecommerce.exceptions.CartNotFoundException;
import com.example.ecommerce.model.Link;
import com.example.ecommerce.model.shipping.ShippingManager;
import com.example.ecommerce.service.shipping.representation.ShippingDetails;
import com.example.ecommerce.service.shipping.ShippingService;
import com.example.ecommerce.service.shipping.representation.response.ShippingDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShippingActivity implements ShippingService {

    @Autowired
    //private ShippingDAOImpl shippingDAO;
    private ShippingManager shippingManager;// = new ShippingManager();

    public ShippingDetailsResponse createShippingInformation(ShippingDetails shippingDetails) {
        if(shippingDetails.getShippingDetails().getCart()==null)
            throw new CartNotFoundException("Your Order is not available with us!");

        String trackingNumber=shippingManager.saveShippingInfo(shippingDetails.getShippingDetails());
        ShippingDetailsResponse shippingDetailsResponse=new
                ShippingDetailsResponse();

        shippingDetailsResponse.setTrackingNumber(trackingNumber);
        setLinks(shippingDetailsResponse);

        return shippingDetailsResponse;
    }

    public String getShippingStatus(String trackingNumber) {
        Optional<String> resultStatus=shippingManager.fetchShippingStatus(trackingNumber);

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

        return shippingManager.modifyStatus(shippingDetails.getShippingDetails()).get();
    }

    private void setLinks(ShippingDetailsResponse response) {
        Link shipStatus = new Link("ship_status", "http://localhost:8080/services/ship/shippingData/" + response.getTrackingNumber());
        response.setLinks(shipStatus);
    }
}
