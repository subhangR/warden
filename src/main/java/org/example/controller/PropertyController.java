package org.example.controller;

import org.example.models.Bill;
import org.example.models.CreatePropertyRequest;
import org.example.models.CreatePropertyResponse;
import org.example.models.DTO.PropertyDTO;
import org.example.models.Inmate;
import org.example.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @PostMapping("/")
    public CreatePropertyResponse putProperty(@RequestBody
                                              CreatePropertyRequest createPropertyRequest){
        return propertyService.createProperty(createPropertyRequest);
    }

    @GetMapping("/{id}")
    public PropertyDTO getProperty(@PathVariable("id") String id) {
        return propertyService.getProperty(id);
    }



}
