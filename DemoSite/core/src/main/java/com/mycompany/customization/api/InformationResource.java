package com.mycompany.customization.api;

import com.mycompany.customization.Information;
import com.mycompany.customization.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by ayushyadevmurari on 10/16/15.
 */
@Component
@Path("/information")
public class InformationResource {

    @Autowired
    @Qualifier("informationService")
    private InformationService informationService;

    @GET
    @Produces("application/json")
    public List<Information> getAllInformations() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        return informationService.getAll();
    }

    @POST
    @Consumes("application/json")
    public Response createInformation(Information information) {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        informationService.saveInformation(information);
        String success = "SUCCESS";
        return Response.status(200).entity(success).build();
    }
}
