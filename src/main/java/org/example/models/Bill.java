package org.example.models;

import lombok.Data;

@Data
public class Bill {

    String billId;
    BillType billType;
    String description;
    String propertyId;
    String createdAt;
    String updatedAt;
    Long dueDateEpochMillis;
    String createdBy;
    Double amount;
    BillStatus billStatus;
    String inmateId;

}
