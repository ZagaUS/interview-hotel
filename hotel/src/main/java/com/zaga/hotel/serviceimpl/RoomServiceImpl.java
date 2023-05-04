package com.zaga.hotel.serviceimpl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.zaga.hotel.entity.Room;
import com.zaga.hotel.repo.RoomRepository;
import com.zaga.hotel.service.RoomService;

@ApplicationScoped
public class RoomServiceImpl implements RoomService {

    @Inject
    RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.listAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public Room createRoom(Room room) {
        roomRepository.persist(room);
        return room;
    }

    public Room updateRoom(Long id, Room updatedRoom) {
        Room room = roomRepository.findById(id);
        if (room != null) {
            room.setRoomNumber(updatedRoom.getRoomNumber());
            room.setRoomType(updatedRoom.getRoomType());
            room.setRoomRate(updatedRoom.getRoomRate());
            room.setNumBeds(updatedRoom.getNumBeds());
            roomRepository.persist(room);
        }
        return room;
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
