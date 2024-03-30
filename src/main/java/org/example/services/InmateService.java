package org.example.services;


import org.example.models.Inmate;
import org.example.models.InmateStatus;
import org.example.repositories.MongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InmateService {

    @Autowired
    MongoRepository mongoRepository;

    public Inmate checkinInmate(Inmate inmate) {
        return mongoRepository.createOrUpdateInmate(inmate);
    }

    public Long checkoutInmate(String inmateId) {
        Inmate inmate = mongoRepository.getEntityById(inmateId, Inmate.class);
        //check pending bills.
        if(inmate.getStatus().equals(InmateStatus.ACTIVE)) {
            inmate.setStatus(InmateStatus.CHECKED_OUT);
            inmate.setCheckoutDateEpochMillis(System.currentTimeMillis());
        }
        return mongoRepository.updateInmate(inmate);
    }

}
