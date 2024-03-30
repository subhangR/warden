package org.example.services;

import org.example.models.Bill;
import org.example.models.CreatePropertyRequest;
import org.example.models.CreatePropertyResponse;
import org.example.models.DTO.PropertyDTO;
import org.example.models.Inmate;
import org.example.models.Owner;
import org.example.models.Property;
import org.example.models.Staff;
import org.example.repositories.MongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PropertyService {

    @Autowired
    MongoRepository mongoRepository;

    @Autowired
    BillsService billsService;

    //admin api.
    public CreatePropertyResponse createProperty(CreatePropertyRequest createPropertyRequest) {

        createPropertyRequest.getOwner().setCreatedAt(System.currentTimeMillis());
        Owner owner = mongoRepository.createEntity(createPropertyRequest.getOwner());
        createPropertyRequest.getProperty().setCreatedAt(System.currentTimeMillis());
        createPropertyRequest.getProperty().setOwner_id(owner.getOwnerId());
        Property property = mongoRepository.createEntity(createPropertyRequest.getProperty());
        return CreatePropertyResponse.builder().property(property).owner(owner).build();
    }

    public PropertyDTO getProperty(String propertyId) {

        Property property = mongoRepository.getEntityById(propertyId, Property.class);
        List<Inmate> inmates = mongoRepository.getInmates(propertyId);
        List<Staff> staff = mongoRepository.getStaffByPropertyId(propertyId);
        List<Bill> bills = billsService.getPropertyBills(propertyId);
        return PropertyDTO.builder()
                .property(property)
                .inmateList(inmates)
                .staff(staff)
                .bills(bills)
                .build();
    }

}
