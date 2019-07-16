package com.accenture.microservicios.service;

import com.accenture.microservicios.controller.UserController;
import com.accenture.microservicios.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Service
@Path("users")
public class UserService {

    private final UserController userController;

    @Autowired
    public UserService(UserController userController) {
        this.userController = userController;
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Response find(@QueryParam("name") String name) {
        if (!StringUtils.isEmpty(name)) {
            return Response.ok(userController.findByName(name), APPLICATION_JSON).build();
        }
        return Response.ok(userController.findAll(), APPLICATION_JSON).build();
    }

    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    public User findById(@PathParam("id") String id) {
        return userController.findById(id);
    }

    @POST
    public Response save(User user, @Context UriInfo uriInfo) throws URISyntaxException {
        User newUser = userController.save(user);
        String uriString = uriInfo.getAbsolutePath().toString() + "/" + newUser.getId();
        return Response.created(new URI(uriString)).build();
    }

    @PUT
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    public User update(@PathParam("id") String id, User user) {
        return userController.update(user);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        userController.delete(id);
        return Response.noContent().build();
    }
}
