package com.example.ecommerce.service.partner;

import com.example.ecommerce.service.partner.representation.PartnerDetails;
import com.example.ecommerce.service.partner.workflow.PartnerActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Controller("partnerService")
@Path("/partners")
public class PartnerResource {

    @Autowired
    private PartnerActivity partnerService;
    @POST
    public ResponseEntity<String> addPartners(@RequestBody PartnerDetails partnerDetails) {

        return new ResponseEntity<>(partnerService.addPartnerData(partnerDetails.getPartnerDetails()),
                HttpStatus.CREATED);
    }


}
