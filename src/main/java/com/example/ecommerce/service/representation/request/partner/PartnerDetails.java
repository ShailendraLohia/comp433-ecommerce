package com.example.ecommerce.service.representation.request.partner;

import com.example.ecommerce.model.partner.PartnerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class PartnerDetails {
    private PartnerInfo partnerDetails;
}
