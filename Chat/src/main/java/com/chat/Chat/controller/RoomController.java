package com.chat.Chat.controller;

import com.chat.Chat.entities.Message;
import com.chat.Chat.entities.Room;
import com.chat.Chat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/chat/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;


    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Room room){
        return this.roomService.createRoom(room.getRoomId());
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<?> join(@PathVariable String roomId){
        return this.roomService.joinRoom(roomId);
    }

    @GetMapping("/messages/{roomId}")
    public ResponseEntity<List<Message>> get(@PathVariable String roomId){
        return this.roomService.getTexts(roomId);
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<?> delete(@PathVariable String roomId){
        return this.roomService.deleteRoom(roomId);
    }
}
