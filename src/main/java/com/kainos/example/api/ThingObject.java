package com.kainos.example.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ThingObject {
    private String description;

    public ThingObject() {}

    public ThingObject(String description) {
        this.description = description;
    }

    @JsonProperty
    public String getValue() { return description; }
}
