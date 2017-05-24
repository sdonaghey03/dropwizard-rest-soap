package com.kainos.example;

import com.kainos.example.health.ApplicationHealthCheck;
import com.kainos.example.jaxws.client.ThingClient;
import com.kainos.example.jaxws.services.IThingService;
import com.kainos.example.jaxws.services.ThingService;
import com.kainos.example.resources.ValueCheckerResource;
import com.kainos.example.services.ValueCheckerService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import javax.xml.ws.Endpoint;
import java.net.MalformedURLException;

public class ExternalApplication extends Application<ExternalConfiguration> {

    public static void main(String[] args) throws Exception {
        new ExternalApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ExternalConfiguration> bootstrap) {

    }

    @Override
    public void run(ExternalConfiguration configuration,
                    Environment environment) throws MalformedURLException {
        ValueCheckerService claimChecker = new ValueCheckerService();
        final ValueCheckerResource valueCheckerResource = new ValueCheckerResource(claimChecker);
        environment.jersey().register(valueCheckerResource);

        ApplicationHealthCheck applicationHealthCheck = new ApplicationHealthCheck();
        environment.healthChecks().register("alive", applicationHealthCheck);

        Endpoint.publish(configuration.getSoapServer().getBaseUrl(), new ThingService());

        ThingClient thingClient = new ThingClient();
        IThingService ts = thingClient.getClientService(configuration);
        ts.getThing(0);
    }
}
