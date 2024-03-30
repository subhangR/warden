package org.example.models;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@Document(collection = "inmates")
public class Inmate {

    @Id
    @MongoId
    String inmateId;

    String name;

    String roomId;
    RoomType roomType;
    Double rentAmount;
    RentFreq rentFreq;
    List<Asset> issuedAssets;
    InmateStatus status;
    Long checkInDateEpochMillis;
    Long checkoutDateEpochMillis;

}
