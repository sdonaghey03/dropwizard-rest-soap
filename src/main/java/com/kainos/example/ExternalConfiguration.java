package com.kainos.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class ExternalConfiguration extends Configuration {

    @JsonProperty
    private SoapServerConfig soapServer;

    public SoapServerConfig getSoapServer() {
        return soapServer;
    }

    public void setSoapServer(SoapServerConfig soapServer) {
        this.soapServer = soapServer;
    }
}
