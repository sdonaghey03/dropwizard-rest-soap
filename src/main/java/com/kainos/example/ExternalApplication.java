package com.kainos.example;

import com.kainos.example.health.ApplicationHealthCheck;
import com.kainos.example.helpers.ConfigurationHelper;
import com.kainos.example.jaxws.client.ThingClient;
import com.kainos.example.jaxws.services.ThingService;
import com.kainos.example.resources.ValueCheckerResource;
import com.kainos.example.services.ValueCheckerService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import javax.xml.ws.Endpoint;

public class ExternalApplication extends Application<ExternalConfiguration> {

    public static void main(String[] args) throws Exception {
        new ExternalApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ExternalConfiguration> bootstrap) {

    }

    @Override
    public void run(ExternalConfiguration configuration,
                    Environment environment){
        ConfigurationHelper.setConfiguration(configuration);
        ValueCheckerService claimChecker = new ValueCheckerService();
        final ValueCheckerResource valueCheckerResource = new ValueCheckerResource(claimChecker);
        environment.jersey().register(valueCheckerResource);

        ApplicationHealthCheck applicationHealthCheck = new ApplicationHealthCheck();
        environment.healthChecks().register("alive", applicationHealthCheck);

        Endpoint.publish(configuration.getSoapServer().getBaseUrl(), new ThingService());

        ThingClient thingClient = ThingClient.getInstance();

        String webRequestResponse = thingClient.getThing(0);
        System.out.println("About to print out the thing: ");
        System.out.println("=====================================================================");
        System.out.println(webRequestResponse);
        System.out.println("=====================================================================");
    }
}
