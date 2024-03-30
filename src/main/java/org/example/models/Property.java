package org.example.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "properties")
public class Property {

    String address;
    String name;
    Location location;
    String owner_id;
    List<Room> rooms;
    Long createdAt;
    PropertySettings propertySettings;

}
