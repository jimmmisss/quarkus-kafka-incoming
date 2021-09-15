package br.com.quarkus.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(IllegalArgumentException ex) {
        var error = new MessageError();
        error.setMessage(ex.getMessage() + ": valor não processável");
        return Response.status(422)
                .entity(error)
                .build();
    }
}