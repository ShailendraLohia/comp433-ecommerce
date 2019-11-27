package com.example.ecommerce.model.shipping;

import com.example.ecommerce.dal.shipping.ShippingDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;

@Component
public class ShippingManager {

    @Autowired
    private ShippingDAOImpl shippingDAO;// = new ShippingDAOImpl();

    public String saveShippingInfo(ShippingStatus shippingStatus){


      return shippingDAO.saveShippingInfo(shippingStatus);
    }

    public Optional<String> fetchShippingStatus(String trackingNumber){
        return shippingDAO.fetchShippingStatus(trackingNumber);
    }

    public Optional<String> modifyStatus(ShippingStatus shippingStatus){
        shippingStatus.setShippingStatus(shippingStatus.getShippingStatus());

        return shippingDAO.modifyStatus(shippingStatus);
    }
}