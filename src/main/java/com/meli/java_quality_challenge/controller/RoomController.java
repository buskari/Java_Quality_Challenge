package com.meli.java_quality_challenge.controller;

import com.meli.java_quality_challenge.model.Room;
import com.meli.java_quality_challenge.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class RoomController {

    private final RoomService service = new RoomService();

    /**
     * Save a list of Rooms at the database
     * @param roomList list of rooms as params
     * @return roomList
     */
    @PostMapping("/api/v1/room")
    public ResponseEntity<List<Room>> saveRoom(@RequestBody List<Room> roomList) {
        return new ResponseEntity<>(service.saveRoom(roomList), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/room")
    public ResponseEntity<List<Room>> getRoom() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/room/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable UUID id) {
        return new ResponseEntity<>(service.find(id), HttpStatus.OK);
    }
}
