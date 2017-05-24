package com.kainos.example.jaxws.models;

import java.io.Serializable;

public class Thing implements Serializable {

    private static final long serialVersionUID = -5577579081118070434L;

    private int id;
    private String description;

    public Thing(int id, String description) {
        this.setId(id);
        this.setDescription(description);
    }

    @Override
    public String toString(){
        return "Thing ID: " + getId() + ", description: " + getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
