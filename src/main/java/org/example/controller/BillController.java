package org.example.controller;

import org.example.models.Bill;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bills")
public class BillController {

    public Bill createOrUpdate(Bill bill) {
        return null;
    }

}
