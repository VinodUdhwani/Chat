package com.chat.Chat.entities;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;
@Embeddable
public class Message {

    private String content;
    private String sender;
    private LocalDateTime timeStamp;

    public Message(String sender,String content) {
        this.content = content;
        this.sender = sender;
        this.timeStamp = LocalDateTime.now();
    }

    public Message(){
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
}
