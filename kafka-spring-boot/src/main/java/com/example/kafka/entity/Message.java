package com.example.kafka.entity;

import java.io.Serializable;

public class Message implements Serializable {
    private String message;
    private String address;

    public Message(){

    }

    public Message(String message, String address) {
        this.message = message;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getMessage() {
        return message;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
