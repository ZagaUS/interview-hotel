package com.zaga.hotel.service;

import java.util.List;

import javax.validation.Valid;

import com.zaga.hotel.entity.Room;

public interface RoomService {

    List<Room> getAllRooms();

    Room getRoomById(Long roomId);

    Room createRoom(Room room);

    Room updateRoom(Long roomId, Room room);

    void deleteRoom(Long roomId);

}
