package com.example.ecommerce.service.customer.workflow;

import com.example.ecommerce.dal.customer.CustomerDAOImpl;
import com.example.ecommerce.model.customer.User;
import com.example.ecommerce.service.customer.CustomerService;
import com.example.ecommerce.service.customer.representation.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerActivity implements CustomerService {

    @Autowired
    private CustomerDAOImpl dao;

    public UserResponse registerCustomer(User user) {
        String userId=dao.addCustomer(user);

        UserResponse userResponse=new UserResponse();
        userResponse.setUserId(userId);
        userResponse.setDateOfBirth(user.getDateOfBirth());
        userResponse.setPrimeMember(user.isPrimeMember());
        userResponse.setUserName(user.getUserName());

        return userResponse;
    }

    public UserResponse searchCustomer(String userId) {
        User user=dao.findCustomer(userId);
        return createUserResponseObject(user);
    }
    public UserResponse modifyCustomerData(User user) {
        user=dao.updateCustomerData(user);

        return createUserResponseObject(user);

    }

    private UserResponse createUserResponseObject(User user) {
        UserResponse userResponse=new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setDateOfBirth(user.getDateOfBirth());
        userResponse.setPrimeMember(user.isPrimeMember());
        userResponse.setUserName(user.getUserName());

        return userResponse;
    }
}
