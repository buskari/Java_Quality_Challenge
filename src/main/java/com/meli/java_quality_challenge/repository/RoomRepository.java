package com.meli.java_quality_challenge.repository;

import com.meli.java_quality_challenge.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RoomRepository implements IRepository<Room> {
    List<Room> roomList = new ArrayList<>();

    @Override
    public List<Room> create(List<Room> rooms) {
        roomList.addAll(rooms);
        return rooms;
    }

    @Override
    public Room create(Room room) {
        roomList.add(room);
        return room;
    }

    @Override
    public List<Room> read(UUID id) {
        return null;
    }

    @Override
    public Room read() {
        return null;
    }

    @Override
    public Boolean update(Room room) {
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        return null;
    }
}
