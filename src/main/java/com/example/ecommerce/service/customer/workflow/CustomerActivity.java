package com.example.ecommerce.service.customer.workflow;

import com.example.ecommerce.dal.customer.CustomerDAOImpl;
import com.example.ecommerce.exceptions.UserNotFoundException;
import com.example.ecommerce.model.Link;
import com.example.ecommerce.model.customer.CustomerManager;
import com.example.ecommerce.model.customer.User;
import com.example.ecommerce.service.customer.CustomerService;
import com.example.ecommerce.service.customer.representation.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerActivity implements CustomerService {


//    private CustomerDAOImpl dao;
    @Autowired
    private CustomerManager customerManager;// = new CustomerManager();

    public UserResponse registerCustomer(User user) {
        String userId = customerManager.addCustomer(user);

        UserResponse userResponse=new UserResponse();
        userResponse.setUserId(userId);
        userResponse.setDateOfBirth(user.getDateOfBirth());
        userResponse.setPrimeMember(user.isPrimeMember());
        userResponse.setUserName(user.getUserName());

        setLinks(userResponse);
        return userResponse;
    }

    public UserResponse searchCustomer(String userId) {
        Optional<User> user=customerManager.findCustomer(userId);

        if(!user.isPresent()) { // User not registered. Don't accept order.
            throw new UserNotFoundException("User not registered,Please get added into system");
        }

        return createUserResponseObject(user.get());
    }
    public UserResponse modifyCustomerData(User user) {
        Optional<User> user_1=customerManager.findCustomer(user.getUserId());

        if(!user_1.isPresent()) { // User not registered. Don't accept order.
            throw new UserNotFoundException("User not registered,Please get added into system");
        }

        Optional<User> user_2=customerManager.updateCustomerData(user);
        return createUserResponseObject(user_2.get());

    }

    private UserResponse createUserResponseObject(User user) {
        UserResponse userResponse=new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setDateOfBirth(user.getDateOfBirth());
        userResponse.setPrimeMember(user.isPrimeMember());
        userResponse.setUserName(user.getUserName());

        return userResponse;
    }

    private void setLinks(UserResponse response) {
        Link viewCustomer = new Link("view",
                "http://localhost:8080/services/userdata/users/"+response.getUserId());

        response.setLinks(viewCustomer);

    }
}
