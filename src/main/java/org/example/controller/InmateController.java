package org.example.controller;

import org.example.models.Inmate;
import org.example.repositories.MongoRepository;
import org.example.services.InmateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/inmates")
public class InmateController {


    @Autowired
    InmateService inmateService;

    @PostMapping("/checkin")
    public Inmate checkinInmate(@RequestBody Inmate inmate) {
        return inmateService.checkinInmate(inmate);
    }

    @PostMapping("/checkout/{id}")
    public Long checkoutInmate(@PathVariable("id") String inmateId){
        return inmateService.checkoutInmate(inmateId);
    }

}
