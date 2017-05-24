package com.kainos.example.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestObject {
    private double value;

    public RequestObject() {}

    public RequestObject(double value) {
        this.value = value;
    }

    @JsonProperty
    public double getValue() { return value; }
}
