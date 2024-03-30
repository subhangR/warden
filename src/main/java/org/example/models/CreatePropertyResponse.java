package org.example.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePropertyResponse {
    Property property;
    Owner owner;
}
