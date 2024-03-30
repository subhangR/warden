package org.example.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "staff")
public class Staff {

    @Id
    @MongoId
    String staffId;

    @Indexed
    String propertyId;
    String jobdesc;
    String name;
    String phone;
    String joinedAt;
    Double salary;
}
