package com.example.eventbus.model;

public class MessageEvent {
    public String mMessage;

    public MessageEvent(String message) {
        mMessage = message;
    }

    public String getMessage() {
        return mMessage;
    }
}
