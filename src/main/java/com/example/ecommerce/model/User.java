package com.example.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "UserInfo")
public class User {
    @Id
    private String userId;
    private String userName;
    private String DOB;
    private boolean primeMember;
}
