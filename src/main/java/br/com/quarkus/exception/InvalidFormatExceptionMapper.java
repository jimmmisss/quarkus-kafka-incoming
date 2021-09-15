package br.com.quarkus.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidFormatExceptionMapper implements ExceptionMapper<InvalidFormatException> {

    @Override
    public Response toResponse(InvalidFormatException ex) {
        var error = new MessageError();
        error.setMessage(ex.getValue() + " : valor não processável");
        return Response.status(422)
                .entity(error)
                .build();
    }
}