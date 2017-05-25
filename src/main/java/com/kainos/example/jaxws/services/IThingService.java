package com.kainos.example.jaxws.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IThingService {

    @WebMethod
    public String getThing(int id);

    @WebMethod
    public void addThing(String description);
}
