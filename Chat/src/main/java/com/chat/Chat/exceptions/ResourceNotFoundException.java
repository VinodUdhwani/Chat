package com.chat.Chat.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String resourceSource;
    private int sourceValue;

    public ResourceNotFoundException(String resourceName, String resourceSource, Integer sourceValue) {
        super();
        this.resourceName = resourceName;
        this.resourceSource = resourceSource;
        this.sourceValue = sourceValue;
    }
}
