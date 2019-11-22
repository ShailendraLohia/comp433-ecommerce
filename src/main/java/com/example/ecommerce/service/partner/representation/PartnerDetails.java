package com.example.ecommerce.service.partner.representation;

import com.example.ecommerce.model.partner.PartnerInfo;
import com.example.ecommerce.service.AbstractRepresentation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class PartnerDetails extends AbstractRepresentation {
    private PartnerInfo partnerDetails;

    public PartnerInfo getPartnerDetails() {
        return partnerDetails;
    }
}
