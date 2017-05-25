package com.kainos.example.jaxws.services;

import com.kainos.example.models.ThingModel;

import javax.jws.WebService;

@WebService(endpointInterface = "com.kainos.example.jaxws.services.IThingService")
public class ThingService implements IThingService {

    private ThingModel thingModel = ThingModel.getInstance();

    @Override
    public String getThing(int id) {
        return thingModel.getThing(id).getDescription();
    }

    @Override
    public void addThing(String description) {
        thingModel.addThing(description);
    }
}
