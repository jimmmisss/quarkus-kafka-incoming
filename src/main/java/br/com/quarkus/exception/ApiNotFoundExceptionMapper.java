package br.com.quarkus.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Provider
public class ApiNotFoundExceptionMapper implements ExceptionMapper<ApiRuntimeException> {

    @Override
    public Response toResponse(ApiRuntimeException e) {
        return Response.status(NOT_FOUND).entity(e.getMessage()).build();
    }
}