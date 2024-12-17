package com.chat.Chat.controller;

import com.chat.Chat.entities.Message;
import com.chat.Chat.entities.Room;
import com.chat.Chat.exceptions.ResourceNotFoundException;
import com.chat.Chat.payloads.MessageRequest;
import com.chat.Chat.repositories.RoomRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/chat/messages")
public class ChatController {

    private RoomRepository roomRepository;

    public ChatController(RoomRepository roomRepository){
        this.roomRepository=roomRepository;
    }

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(@RequestBody MessageRequest messageRequest, @DestinationVariable String roomId){
        Room room = roomRepository.findByRoomId(roomId);

        Message message=new Message();
        message.setContent(messageRequest.getContent());
        message.setSender(messageRequest.getSender());
        message.setTimeStamp(LocalDateTime.now());

        if(room!=null){
            room.getMessages().add(message);
            roomRepository.save(room);
        }else {
            throw new ResourceNotFoundException("Room","roodId: "+roomId,0);
        }
        return message;
    }
}
