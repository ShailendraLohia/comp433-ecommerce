package com.example.ecommerce.service.customer.representation.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String userId;
    private String userName;
    private Date dateOfBirth;
    @Getter
    private boolean primeMember;
}
