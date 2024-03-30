package org.example.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
public class Owner {

    String userId;

    @MongoId
    @Id
    String ownerId;

    String pointOfContactMobile;
    Long createdAt;

}
