package com.example.ecommerce.model.shipping;

import com.example.ecommerce.dal.shipping.ShippingDAOImpl;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;

public class ShippingManager {

    private ShippingDAOImpl shippingDAO = new ShippingDAOImpl();

    public String saveShippingInfo(ShippingStatus shippingStatus){
      //Generate Primary Key for customer
      String trackingNumber = (Instant.now().toEpochMilli()) + shippingStatus.getCart().getCartId();

      //Set Shipping Status fields
      shippingStatus.setTrackingNumber(trackingNumber);
      shippingStatus.setCart(shippingStatus.getCart());
      shippingStatus.setShippedBy(shippingStatus.getShippedBy());
      shippingStatus.setShippingDate(LocalDate.now());
      shippingStatus.setArrivalDate(shippingStatus.getShippingDate().plusDays(2));
      shippingStatus.setShippingStatus(shippingStatus.getShippingStatus());

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