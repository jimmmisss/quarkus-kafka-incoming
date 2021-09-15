package br.com.quarkus.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException ex) {
        var error = new MessageError();
        error.setMessage(ex.getMessage());
        return Response.status(Status.NOT_FOUND)
                .entity(error)
                .build();
    }
}