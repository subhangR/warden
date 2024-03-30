package org.example.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CreatePropertyRequest {

    Property property;
    Owner owner;

}
