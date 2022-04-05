package com.meli.java_quality_challenge.controller;

import com.meli.java_quality_challenge.model.Room;
import com.meli.java_quality_challenge.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
