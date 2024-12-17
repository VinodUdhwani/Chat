package com.chat.Chat.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String resourceSource;
    private int sourceValue;

    public ResourceNotFoundException(String resourceName, String resourceSource, Integer sourceValue) {
        super(String.format("%s not found with %s : %s",resourceName,resourceSource,sourceValue));
        this.resourceName = resourceName;
        this.resourceSource = resourceSource;
        this.sourceValue = sourceValue;
    }
}
