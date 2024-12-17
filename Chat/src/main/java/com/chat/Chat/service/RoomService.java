package com.chat.Chat.service;

import com.chat.Chat.entities.Message;
import com.chat.Chat.entities.Room;
import com.chat.Chat.repositories.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ModelMapper modelMapper;

    // create room
    public ResponseEntity<?> createRoom(String roomId){

        if(this.roomRepository.findByRoomId(roomId)!=null){
            return new ResponseEntity<>("room already exists with this room id!", HttpStatus.BAD_REQUEST);
        }else {
            Room room=new Room();
            room.setRoomId(roomId);
            Room createdRoom = this.roomRepository.save(room);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdRoom);
        }
    }


    // join room

    public ResponseEntity<?> joinRoom(String roomId){
        if(this.roomRepository.findByRoomId(roomId)!=null){
            return ResponseEntity.status(HttpStatus.OK).body(this.roomRepository.findByRoomId(roomId));
        }else {
            return new ResponseEntity<>("room does not found",HttpStatus.BAD_REQUEST);
        }
    }


    // get messages

    public ResponseEntity<List<Message>> getMessages(String roomId){
        Room room = this.roomRepository.findByRoomId(roomId);

        if(room==null){
            return ResponseEntity.badRequest().build();
        }else {
            List<Message> messageList=room.getMessages();
            return new ResponseEntity<>(messageList,HttpStatus.OK);
        }
    }


    // delete room

    public ResponseEntity<?> deleteRoom(String roomId){
        Room room=this.roomRepository.findByRoomId(roomId);
        if(room==null)
            return ResponseEntity.badRequest().body("room does not exists");
        else{
            this.roomRepository.delete(room);
            return new ResponseEntity<>("room deleted successfully",HttpStatus.OK);
        }
    }
}
