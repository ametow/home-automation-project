package edu.miu.cs.najeeb.spring.eahomeautomationproject.service;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Room;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Room not found"));
    }

    public void deleteRoom(Long id) {
        roomRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Room not found"));
        roomRepository.deleteById(id);
    }

    public Room updateRoom(Long id, Room room) {
        Room existingRoom = roomRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Room not found"));
        existingRoom.setName(room.getName());
        existingRoom.setHome(room.getHome());
        return roomRepository.save(existingRoom);
    }

}
