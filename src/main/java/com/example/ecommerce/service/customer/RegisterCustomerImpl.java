package com.example.ecommerce.service.customer;

import com.example.ecommerce.dao.customer.DAOImpl;
import com.example.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerImpl {

    @Autowired
    private DAOImpl dao;

    public String registerCustomer(User user) {

        return dao.addCustomer(user);
    }
}
