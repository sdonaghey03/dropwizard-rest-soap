package com.kainos.example.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ResponseObject {
    private ArrayList<String> messages;

    public ResponseObject() {}

    public ResponseObject(ArrayList<String> messages) {
        this.messages = messages;
    }

    @JsonProperty
    public ArrayList<String> getMessages() { return messages; }
}
