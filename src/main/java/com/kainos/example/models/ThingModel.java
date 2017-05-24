package com.kainos.example.models;

import com.kainos.example.jaxws.models.Thing;

import java.util.ArrayList;

public class ThingModel {

    private static ThingModel instance;

    private static ArrayList<Thing> thingList = new ArrayList<Thing>();

    private int nextThingId = 0;

    // Private constructor for singleton
    private ThingModel() {}

    public static ThingModel getInstance() {
        if (instance == null) {
            instance = new ThingModel();
        }
        return instance;
    }

    public void addThing(String description) {
        thingList.add(new Thing(nextThingId, description));
        nextThingId++;
    }

    public void removeThing(Thing thing) {
        thingList.remove(thing);
    }

    public Thing getThing(int id) {
        return thingList.get(id);
    }

    public ArrayList<Thing> getThings() {
        return thingList;
    }
}
