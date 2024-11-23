package com.boss.chat;

public class ChatMessage {

    private String message;
    private boolean isSender;

    public ChatMessage(String message, boolean isSender) {
        this.message = message;
        this.isSender = isSender;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSender() {
        return isSender;
    }
}