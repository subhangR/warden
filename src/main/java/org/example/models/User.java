package org.example.models;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    String user_id;
    String firstName;
    String lastName;
    String phone;
    Long createdAtEpochMillis;
}
