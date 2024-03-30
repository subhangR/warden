package org.example.models.DTO;

import lombok.Builder;
import org.example.models.Bill;
import org.example.models.Inmate;
import org.example.models.Property;
import org.example.models.Room;
import org.example.models.Staff;

import java.util.List;

@Builder
public class PropertyDTO {

    Property property;
    List<Inmate> inmateList;
    List<Staff> staff;
    List<Bill> bills;
}
