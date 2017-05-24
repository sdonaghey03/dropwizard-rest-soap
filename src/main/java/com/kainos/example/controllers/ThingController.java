package com.kainos.example.controllers;

import com.kainos.example.models.ThingModel;
import com.kainos.example.views.ThingView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/thing")
public class ThingController {

    ThingModel thingModel = ThingModel.getInstance();

    public ThingController() {
        super();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.TEXT_HTML})
    public ThingView getThing(@PathParam("id") int id) {
        return new ThingView(thingModel.getThing(id));
    }
}
