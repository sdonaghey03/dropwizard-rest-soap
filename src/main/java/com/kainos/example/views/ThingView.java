package com.kainos.example.views;

import com.kainos.example.jaxws.models.Thing;
import io.dropwizard.views.View;

public class ThingView extends View {
    private final Thing thing;

    public ThingView(Thing thing) {
        super("thing.mustache");
        this.thing = thing;
    }

    public Thing getThing() {
        return thing;
    }
}
