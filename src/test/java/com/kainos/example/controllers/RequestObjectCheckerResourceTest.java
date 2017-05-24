package com.kainos.example.controllers;

import com.kainos.example.api.RequestObject;
import com.kainos.example.api.ResponseObject;
import com.kainos.example.services.IValueCheckerService;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;

import javax.ws.rs.client.Entity;

import static org.mockito.Mockito.when;

public class RequestObjectCheckerResourceTest {
    private static IValueCheckerService valueCheckerService = mock(IValueCheckerService.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ValueCheckerController(valueCheckerService))
            .build();

    @Test
    public void checkCanPostToEndpointAndGetResponse() throws Exception {
        RequestObject requestObject = new RequestObject(100);
        when(valueCheckerService.checkValue(any(RequestObject.class)))
                .thenReturn(new ResponseObject(null));

        ResponseObject responseObject = resources.client()
                .target("/check-value")
                .request()
                .post(Entity.json(requestObject), ResponseObject.class);

        assertEquals(null, responseObject.getMessages());
    }
}
