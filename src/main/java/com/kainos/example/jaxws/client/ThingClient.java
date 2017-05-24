package com.kainos.example.jaxws.client;

import com.kainos.example.ExternalConfiguration;
import com.kainos.example.jaxws.services.IThingService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class ThingClient {

    private static ThingClient instance;
    private static IThingService thingService;

    private ThingClient (){}

    private void initialise (ExternalConfiguration configuration){
        try {
            URL url = new URL(configuration.getSoapServer().getBaseUrl());
            QName qname = new QName("http://services.jaxws.example.kainos.com/", "ThingServiceService");
            Service service = Service.create(url, qname);
            this.thingService = service.getPort(IThingService.class);
        }
        catch (MalformedURLException e){
            e.printStackTrace();
            System.out.println("Failed to initialise ThingClient");
        }
    }

    public static ThingClient getInstance (ExternalConfiguration configuration) {
        if (instance == null) {
            instance = new ThingClient();
            instance.initialise(configuration);
        }
        return instance;
    }

    public IThingService getClientService () {
        return thingService;
    }
}
