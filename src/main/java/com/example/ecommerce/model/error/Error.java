package com.example.ecommerce.model.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Error {
    private HttpStatus status;
    private String errorMessages;
    private UUID uuid;
    private Date timestamp;

    public Error(HttpStatus status, String errorMessages, Date timestamp) {
        this.status=status;
        this.errorMessages=errorMessages;
        this.timestamp=timestamp;
        uuid= UUID.randomUUID();
    }
}
