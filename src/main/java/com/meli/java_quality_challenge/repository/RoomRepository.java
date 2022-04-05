package com.meli.java_quality_challenge.repository;

import com.meli.java_quality_challenge.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RoomRepository implements IRepository<Room> {
    List<Room> roomList = new ArrayList<>();

    @Override
    public List<Room> create(List<Room> rooms) {
        roomList.addAll(rooms);
        return rooms;
    }

    @Override
    public List<Room> read() {
        return roomList;
    }

    @Override
    public Room read(UUID id) {
        List<Room> list = roomList
                .stream()
                .filter(
                        room -> room.getId().equals(id)
                ).collect(Collectors.toList());

        if (list.size() == 1) {
            return list.get(0);
        }

        throw new RuntimeException("There is no room with id " + id);
    }

    @Override
    public Room update(Room roomToUpdate) {
        UUID id = roomToUpdate.getId();
        List<Room> list = roomList.stream().filter(room -> room.getId().equals(id)).collect(Collectors.toList());

        if (list.size() == 1) {
            roomList.set(roomList.indexOf(list.get(0)), roomToUpdate);
            return roomToUpdate;
        }

        throw new RuntimeException("There is no room with id " + id + ". Please, create a new one");
    }

    @Override
    public String delete(UUID id) {
        List<Room> list = roomList.stream().filter(room -> room.getId().equals(id)).collect(Collectors.toList());

        if (list.size() == 1) {
            roomList.remove(list.get(0));
            return "The room of id " + id + " was successfully deleted";
        }

        throw new RuntimeException("There is no room with id " + id + " to delete");
    }
}
