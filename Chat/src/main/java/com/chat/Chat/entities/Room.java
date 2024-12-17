package com.chat.Chat.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String roomId;

    @ElementCollection
    @CollectionTable(name = "room_messages", joinColumns = @JoinColumn(name = "room_id"))
    @Column(name = "message")
    private List<Message> messages=new ArrayList<>();

    public Room(String id, List<Message> messages, String roomId) {
        this.id = id;
        this.messages = messages;
        this.roomId = roomId;
    }

    public Room(){
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
