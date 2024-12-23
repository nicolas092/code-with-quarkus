package org.acme;

import jakarta.json.Json;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/Conversion")
public class Endpoints {

    @POST
    @Path("/km-to-miles")
    // @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String convertKmToMile(String km) {
        double kmDouble = Double.parseDouble(km);
        return String.valueOf(kmDouble * 0.6213712);
    }

    @GET
    @Path("/knots-to-km/{knots}")
    // @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String convertKnotsToKm(@PathParam("knots") String knots) {
        Double kmDouble = Double.parseDouble(knots);
        return Json.createObjectBuilder()
                .add("value", kmDouble * 1.852)
                .build().toString();
    }
}