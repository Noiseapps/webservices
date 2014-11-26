package com.noiseapps;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("cars")
public class CarResource {


    String[] carNames = new String[] { "car1", "car2", "car3"};

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllCarNames(@QueryParam("color") String color){
        StringBuilder names = new StringBuilder();

        if(null != color){
            names.append(color).append(" - ");
        }

        for(String name : carNames){
            names.append(name).append(", ");
        }
        return names.toString();
    }


    @GET
    @Path("{id}")
    public String getCarName(@PathParam("id") int id){
        return carNames[id];
    }

}
