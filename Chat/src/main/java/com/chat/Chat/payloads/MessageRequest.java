package com.chat.Chat.payloads;

import com.chat.Chat.entities.Room;

import java.time.LocalDateTime;

public class MessageRequest {

    private String content;
    private String sender;
    private LocalDateTime timeStamp;
    private Room room;

    public MessageRequest(String content, Room room, String sender, LocalDateTime timeStamp) {
        this.content = content;
        this.room = room;
        this.sender = sender;
        this.timeStamp = timeStamp;
    }

    public MessageRequest(){
        super();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
