package com.meli.java_quality_challenge.service;

import com.meli.java_quality_challenge.model.Room;
import com.meli.java_quality_challenge.repository.RoomRepository;

import java.util.List;

public class RoomService {

    private final RoomRepository repository = new RoomRepository();

    public List<Room> saveRoom(List<Room> roomList) {
        return repository.create(roomList);
    }
}
