package br.com.quarkus.controller;

import br.com.quarkus.controller.openapi.CustomerOpenApi;
import br.com.quarkus.payload.request.CustomerRequest;
import br.com.quarkus.payload.response.CustomerResponse;
import br.com.quarkus.service.CustomerService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.NO_CONTENT;

@Path("/v1/cliente")
@Tag(name = "Cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController implements CustomerOpenApi {

    @Inject
    CustomerService service;

    @GET
    @Path("/page/{page}")
    public List<CustomerResponse> findPage(@PathParam("page") int page) {
        return service.findPage(page);
    }

    @GET
    @Path("/{customerId}")
    public CustomerResponse findCustomerById(@PathParam("customerId") Long customerId) {
        return service.findCustomerById(customerId);
    }

    @PUT
    @Path("/{customerId}")
    public Response update(@PathParam("customerId") Long customerId,
                           @Valid CustomerRequest request) {
        service.update(customerId, request);
        return Response.status(NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(NO_CONTENT).build();
    }
}