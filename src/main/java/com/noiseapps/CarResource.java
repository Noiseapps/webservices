package com.noiseapps;

import com.noiseapps.beans.Car;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.HashMap;
import java.util.Map;

@Path("cars")
public class CarResource {

    private static Map<Integer, Car> cars = new HashMap<>();


    static {
        cars.put(1, new Car(1, "Audi", "A1"));
        cars.put(2, new Car(2, "Audi", "A3"));
        cars.put(3, new Car(3, "VW", "Golf"));
    }

    @GET
    @Path("{id}")
    @Produces("application/xml")
    public Car getCarAsXml(@PathParam("id") int id){
        return cars.get(id);
    }


    @PUT
    @Path("{id}")
    @Consumes("application/xml")
    public Response addCar(@Context UriInfo uriInfo, @PathParam("id")int id, Car car){
        cars.put(id, car);
        return Response.created(uriInfo.getAbsolutePath()).build();
    }

}
