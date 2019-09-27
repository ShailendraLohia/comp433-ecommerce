package com.example.ecommerce.service;

import com.example.ecommerce.dao.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerImpl {

    @Autowired
    private DAOImpl dao;

    public String registerCustomer() {
        return dao.findCustomer();
    }
}
