package com.kainos.example.resources;

import com.kainos.example.api.RequestObject;
import com.kainos.example.api.ResponseObject;
import com.kainos.example.services.IValueCheckerService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/check-value")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class ValueCheckerResource {
    private IValueCheckerService valueCheckerService;

    public ValueCheckerResource(IValueCheckerService valueCheckerService) {
        this.valueCheckerService = valueCheckerService;
    }

    @POST
    public ResponseObject processRequest(RequestObject requestObject) {
        return valueCheckerService.checkValue(requestObject);
    }
}
