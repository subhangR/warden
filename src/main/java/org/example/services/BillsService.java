package org.example.services;

import org.example.models.Bill;
import org.example.repositories.MongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillsService {

    @Autowired
    MongoRepository mongoRepository;

    List<Bill> getPropertyBills(String propertyId) {
        return null;
    }

}
