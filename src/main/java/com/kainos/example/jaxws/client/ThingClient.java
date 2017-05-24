package com.kainos.example.jaxws.client;

import com.kainos.example.ExternalConfiguration;
import com.kainos.example.jaxws.services.IThingService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class ThingClient {

    public IThingService getClientService (ExternalConfiguration configuration) throws MalformedURLException{
        URL url = new URL(configuration.getSoapServer().getBaseUrl());
        QName qname = new QName("http://services.jaxws.example.kainos.com/", "ThingServiceService");
        Service service = Service.create(url, qname);
        return service.getPort(IThingService.class);
    }
}
