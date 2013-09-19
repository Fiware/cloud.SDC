package com.telefonica.euro_iaas.sdc.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.telefonica.euro_iaas.sdc.model.dto.Attributes;

public interface SystemConfigurationResource {

    /**
     * Find all system configuration properties.
     * @return the configuration properties.
     */
    @GET
    @Path("/")
    @Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    Attributes findAttributes();

    /**
     * Update the attributes and persist the new values.
     * @param attributes the attributes
     */
    @PUT
    @Path("/")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateAttributes(Attributes attributes);
}
