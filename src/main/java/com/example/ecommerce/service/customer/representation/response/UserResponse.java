package com.example.ecommerce.service.customer.representation.response;

import com.example.ecommerce.service.AbstractRepresentation;
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
public class UserResponse extends AbstractRepresentation {
    private String userId;
    private String userName;
    private Date dateOfBirth;
    @Getter
    private boolean primeMember;
}
