package com.meli.java_quality_challenge.service;

import com.meli.java_quality_challenge.model.Room;
import com.meli.java_quality_challenge.repository.RoomRepository;

import java.util.List;
import java.util.UUID;

public class RoomService {

    private final RoomRepository repository = new RoomRepository();

    public List<Room> saveRoom(List<Room> roomList) {
        return repository.create(roomList);
    }

    public List<Room> findAll() {
        return repository.read();
    }

    public Room find(UUID id) {
        return repository.read(id);
    }
}
