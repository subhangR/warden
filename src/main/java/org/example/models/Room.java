package org.example.models;

import lombok.Data;

import java.util.List;

@Data
public class Room {
    String roomNum;
    List<RoomType> roomTypes;
}
