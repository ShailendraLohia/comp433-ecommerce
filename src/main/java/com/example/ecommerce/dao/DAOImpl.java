package com.example.ecommerce.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOImpl {
    @Autowired
    private SessionFactory sessionFactory;

    public String findCustomer() {
        return "customer found!";
    }

}
