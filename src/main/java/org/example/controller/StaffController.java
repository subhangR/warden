package org.example.controller;

import org.example.models.Staff;
import org.example.repositories.MongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    MongoRepository mongoRepository;

    @PostMapping("/")
    public Staff createStaff(@RequestBody Staff staff){
       return  mongoRepository.createEntity(staff);
    }

    @GetMapping("/{id}")
    public List<Staff> getAllStaff(@PathVariable("id") String propertyId) {

        return mongoRepository.getStaffByPropertyId(propertyId);

    }

}
