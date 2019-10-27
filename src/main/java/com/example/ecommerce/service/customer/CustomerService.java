package com.example.ecommerce.service.customer;

import com.example.ecommerce.model.customer.User;
import com.example.ecommerce.service.customer.representation.response.UserResponse;

public interface CustomerService {
    public UserResponse registerCustomer(User user);
    public UserResponse searchCustomer(String userId);
    public UserResponse modifyCustomerData(User user);
}
