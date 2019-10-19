package com.example.ecommerce.service.workflow.customer;

import com.example.ecommerce.dal.customer.CustomerDAOImpl;
import com.example.ecommerce.model.customer.User;
import com.example.ecommerce.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerActivity implements CustomerService {

    @Autowired
    private CustomerDAOImpl dao;

    public String registerCustomer(User user) {

        return dao.addCustomer(user);
    }
}
