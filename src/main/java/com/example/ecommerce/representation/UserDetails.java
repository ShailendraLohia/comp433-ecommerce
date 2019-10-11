package com.example.ecommerce.representation;

import com.example.ecommerce.model.customer.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
    private User userData;
}
